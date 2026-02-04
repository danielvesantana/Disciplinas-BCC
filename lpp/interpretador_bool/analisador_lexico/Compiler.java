package analisador_lexico;

import generics.Pair;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private final List<String> lines;
    private final List<Rule> rules;
    private String codePreProcessed;
    private final RuleMethod rm;
    private final String filename;

    public Compiler(List<String> lines){
        this.lines = lines;
        this.codePreProcessed = "";
        this.filename = "pre_processed.bool";
        rules = new ArrayList<>();
        rm = new RuleMethod();
    }
    
    public void start() throws IOException{
        createRules();
        processRules();
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

    public void writeFile() throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(codePreProcessed);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}