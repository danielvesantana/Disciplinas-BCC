package analisador_lexico;
import generics.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleMethod{

    public String varEqNum(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "const " + matches.get(2) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(2) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqObjAtr(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "set " + matches.get(3) + "\n";
        newInst += "load " + matches.get(2) + "\n";
        newInst += "get " + matches.get(3) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqObjMet(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(2) + "\n";
        newInst += "call " + matches.get(3) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqObjMetAtr(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);
        List<String> args = getArgs(matches.get(4));
        
        String newInst = "";
        for(int i = 0; i < args.size(); i++){
            newInst += "load " + args.get(i) + "\n";
        }
        newInst += "load " + matches.get(2) + "\n";
        newInst += "call " + matches.get(3) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqNewObj(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "new " + matches.get(2) + "\n";
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String varEqVarOpeVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(2) + "\n";
        newInst += "load " + matches.get(4) + "\n";

        switch (matches.get(3)) {
            case "+" -> newInst += """
                                   add
                                   """;
            case "-" -> newInst += """
                                   sub
                                   """;
            case "*" -> newInst += """
                                   mul
                                   """;
            case "/" -> newInst += """
                                   div
                                   """;
            default -> {
            }
        }
        newInst += "store " + matches.get(1) + "\n";

        return newInst;
    }

    public String objAtrEqNum(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "const " + matches.get(3) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String objAtrEqVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(3) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String objAtrEqObjAtr(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(3) + "\n";
        newInst += "get " + matches.get(4) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String objAtrEqObjMet(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(3) + "\n";
        newInst += "call " + matches.get(4) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String objAtrEqObjMetAtr(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);
        List<String> args = getArgs(matches.get(4));
        
        String newInst = "";
        for(int i = 0; i < args.size(); i++){
            newInst += "load " + args.get(i) + "\n";
        }
        newInst += "load " + matches.get(3) + "\n";
        newInst += "call " + matches.get(4) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String objAtrEqNewObj(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "new " + matches.get(3) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n"; 

        return newInst;
    }

    public String objAtrEqVarOpeVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(3) + "\n";
        newInst += "load " + matches.get(5) + "\n";

        switch (matches.get(4)) {
            case "+" -> newInst += """
                                   add
                                   """;
            case "-" -> newInst += """
                                   sub
                                   """;
            case "*" -> newInst += """
                                   mul
                                   """;
            case "/" -> newInst += """
                                   div
                                   """;
            default -> {
            }
        }

        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public String ifVarOpeVarThen(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "load " + matches.get(3) + "\n";
        
        switch(matches.get(2)){
            case "eq" -> newInst += "eq\n";
            case "ne" -> newInst += "ne\n";
            case "gt" -> newInst += "gt\n";
            case "ge" -> newInst += "ge\n";
            case "lt" -> newInst += "lt\n";
            case "le" -> newInst += "le\n";
            default -> {
            }
        }
        newInst += """
                   if <n>
                   """;

        return newInst;
    }

    public String elseStatment(Pair<String, String> pm){
        String newInst = "";
        newInst += "else <n>\n";

        return newInst;
    }

    public String returnVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "ret\n";

        return newInst;
    }

    public String objMet(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "call " + matches.get(2) + "\n";

        return newInst;
    }

    public String objMetVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);
        List<String> args = getArgs(matches.get(3));
        
        String newInst = "";
        for(int i = 0; i < args.size(); i++){
            newInst += "load " + args.get(i) + "\n";
        }

        newInst += "load " + matches.get(1) + "\n";
        newInst += "call " + matches.get(2) + "\n";

        return newInst;
    }

    public String varProEqVar(Pair<String, String> pm){
        String pattern = pm.getFirstValue();
        String line = pm.getSecondValue();
        List<String> matches = getMatcherGroup(pattern, line);

        String newInst = "";
        newInst += "load " + matches.get(3) + "\n";
        newInst += "load " + matches.get(1) + "\n";
        newInst += "set " + matches.get(2) + "\n";

        return newInst;
    }

    public List<String> getArgs(String parameters){
        Pattern p = Pattern.compile("([a-zA-Z]+)");
        Matcher m = p.matcher(parameters);
        List<String> args = new ArrayList<>();

        while(m.find()){
            args.add(m.group());
        }

        return args;
    }

    public List<String> getMatcherGroup(String pattern, String line){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        List<String> matcher = new ArrayList<>();

        if(m.matches()){
            for(int i = 0; i <= m.groupCount(); i++){
                matcher.add(m.group(i));
            }
        }

        return matcher;
    }
}