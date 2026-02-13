package intermediate_code;

import generics.Pair;
import java.util.function.Function;

public class Rule {
    private final String pattern;
    private final Function<Pair<String, String>, String> translator;

    public Rule(String pattern, Function<Pair<String, String>, String> translator){
        this.pattern = pattern;
        this.translator = translator;
    }

    public String getPattern(){
        return pattern;
    }

    public Function<Pair<String, String>, String> getTranslator(){
        return translator;
    }
}
