package intermediate_code;

import generics.Pair;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translation {
    private final List<String> lines;
    private final List<Rule> rules;
    private final RuleMethod rm;
    private final String filename;
    private String codePreProcessed;

    public Translation(List<String> lines){
        this.lines = lines;
        this.codePreProcessed = "";
        this.filename = "pre_processed.bool";
        this.rules = new ArrayList<>();
        this.rm = new RuleMethod();
    }
    
    public void start() throws IOException{
        createRules();
        processRules();
        calculateIfDistance();
        calculateElseDistance();
        writeFile();
    }
    
    public void createRules(){
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([0-9]+)", rm::varEqNum)); // var = number
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([a-zA-Z]+)", rm::varEqVar)); // var = var
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)", rm::varEqObjAtr)); // var = obj.atr 
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)\\(\\)", rm::varEqObjMet)); //var = obj.method()
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)\\(([^)]*)\\)", rm::varEqObjMetAtr)); //var = obj.method(var1, var2, ..., varN)
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\snew\\s([a-zA-Z]+)", rm::varEqNewObj)); //var = new Obj
        rules.add(new Rule("^([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\s([+\\-*/])\\s([a-zA-Z]+)", rm::varEqVarOpeVar)); //var = var [+-*/] var
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([0-9]+)", rm::objAtrEqNum)); //obj.atr = number
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([a-zA-Z]+)", rm::objAtrEqVar)); // obj.atr = var
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)", rm::objAtrEqObjAtr)); // obj.atr = obj.atr
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)\\(\\)", rm::objAtrEqObjMet)); // obj.atr = obj.method()
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\.([a-zA-Z]+)\\(([^)]*)\\)", rm::objAtrEqObjMetAtr)); // obj.atr = obj.method(var1, var2, ..., varN)
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\snew\\s([a-zA-Z]+)", rm::objAtrEqNewObj)); // obj.atr = new Obj
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\s=\\s([a-zA-Z]+)\\s([+\\-*/])\\s([a-zA-Z]+)", rm::objAtrEqVarOpeVar)); // obj.atr = var [+-*/] var
        rules.add(new Rule("^if\\s([a-zA-Z]+)\\s(eq|ne|gt|ge|lt|le)\\s([a-zA-Z]+)\\sthen", rm::ifVarOpeVarThen)); // if var (eq|ne|gt|ge|lt|le) var then
        rules.add(new Rule("^else", rm::elseStatment)); //else
        rules.add(new Rule("^return\\s([a-zA-Z]+)", rm::returnVar)); // return var
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\(\\)", rm::objMet)); // obj.method()
        rules.add(new Rule("^([a-zA-Z]+)\\.([a-zA-Z]+)\\(([^)]*)\\)", rm::objMetVar)); // obj.method(var1, var2, ..., varN)
        rules.add(new Rule("^([a-zA-Z]+)\\.(_prototype)\\s=\\s([a-zA-Z]+)", rm::varProEqVar)); // var._prototype = var
    }

    public void processRules(){
        for(String line : lines){
            boolean flag = false;
            for(Rule rule : rules){
                if(line.matches(rule.getPattern())){
                    codePreProcessed += rule.getTranslator().apply(new Pair<>(rule.getPattern(), line));
                    flag = true;
                    break;
                }
            }
            if(!flag)
                codePreProcessed += line + "\n";
        }
        codePreProcessed = codePreProcessed.trim();
    }

    public void calculateIfDistance(){
        try (Scanner scanner = new Scanner(codePreProcessed)) {
            Pattern p = Pattern.compile("if <n>");
            Matcher m;
            String newcodePreProcessed = "";

            while(scanner.hasNextLine()){
                boolean flag = false;
                String line = scanner.nextLine();
                m = p.matcher(line);

                if(m.matches()){
                    flag = true;
                    String ifLine = "";
                    String ifScope = "";
                    int count = 0;
                    while(!line.equals("else <n>") && !line.equals("end-if")){
                        line = scanner.nextLine();
                        count++;
                        ifScope += line + "\n";
                    }

                    ifLine = "if " + (count-1) + "\n";
                    newcodePreProcessed += ifLine + ifScope;
                }
                if(!flag){
                    newcodePreProcessed += line + "\n";
                }
            }

            codePreProcessed = newcodePreProcessed;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void calculateElseDistance(){
        try (Scanner scanner = new Scanner(codePreProcessed)) {
            Pattern p = Pattern.compile("else <n>");
            Matcher m;

            String newcodePreProcessed = "";

            while(scanner.hasNextLine()){
                boolean flag = false;
                String line = scanner.nextLine();
                m = p.matcher(line);

                if(m.matches()){
                    flag = true;
                    String elseLine = "";
                    String elseScope = "";
                    int count = 0;
                    while(!line.equals("end-if")){
                        line = scanner.nextLine();
                        count++;
                        elseScope += line + "\n";
                    }

                    elseLine = "else " + (count-1) + "\n";
                    newcodePreProcessed += elseLine + elseScope;
                }
                if(!flag){
                    newcodePreProcessed += line + "\n";
                }
            }

            codePreProcessed = newcodePreProcessed.trim();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void writeFile() throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(codePreProcessed);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}