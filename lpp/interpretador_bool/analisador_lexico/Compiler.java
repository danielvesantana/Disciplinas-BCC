package analisador_lexico;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private List<String> lines;
    private List<Rule> rules;

    public Compiler(List<String> lines){
        this.lines = lines;
        rules = new ArrayList<>();
    }
    
    public void start(){
        createRules();
        processRules();
    }
    
    public void createRules(){
        rules.add(new Rule("^[a-zA-Z]+\\s=\\s[0-9]+")); // var = number
        rules.add(new Rule("^[a-zA-Z]+\\s=\\s[a-zA-Z]+")); // var = var
        rules.add(new Rule("^[a-zA-Z]+\\s=\\s[a-zA-Z]+\\.[a-zA-Z]+")); // var = obj.atr 
        rules.add(new Rule("^[a-zA-Z]+\\s=\\s[a-zA-Z]+\\\\.[a-zA-Z]+\\(\\)")); //var = obj.method()
        rules.add(new Rule("^[a-zA-Z]+\\s=\\s[a-zA-Z]+\\\\.[a-zA-Z]+\\([a-zA-Z]+(,\\s[a-zA-Z])*\\)")); //var = obj.method(var1, var2, ..., varN)
        rules.add(new Rule("^[a-zA-Z]+\\.[a-zA-Z]+\\s=\\s[0-9]+")); //obj.atr = number
        rules.add(new Rule("^[a-zA-Z]+\\.[a-zA-Z]+\\s=\\s[a-zA-Z]+")); // obj.atr = var
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
        rules.add(new Rule(""));
    }

    public void processRules(){

    }
}