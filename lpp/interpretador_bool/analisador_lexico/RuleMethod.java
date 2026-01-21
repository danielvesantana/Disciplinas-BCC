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

        String newInst = "";
        for(int i = 4; i < matches.size(); i++){
            newInst += "load " + matches.get(i) + "\n";
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
        

        return "";
    }

    public String objAtrEqNum(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqVar(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqObjAtr(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqObjMet(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqObjMetAtr(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqNewObj(Pair<String, String> pm){

        return "";
    }

    public String objAtrEqVarOpeVar(Pair<String, String> pm){

        return "";
    }

    public String ifVarOpeVarThen(Pair<String, String> pm){

        return "";
    }

    public String elseStatment(Pair<String, String> pm){

        return "";
    }

    public String returnVar(Pair<String, String> pm){

        return "";
    }

    public String objMet(Pair<String, String> pm){

        return "";
    }

    public String objMetVar(Pair<String, String> pm){

        return "";
    }

    public String varProEqVar(Pair<String, String> pm){

        return "";
    }

    public String newObj(Pair<String, String> pm){

        return "";
    }

    public List<String> getMatcherGroup(String pattern, String line){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        List<String> matches = new ArrayList<>();

        while(m.find()){
            matches.add(m.group());
        }

        return matches;
    }
}