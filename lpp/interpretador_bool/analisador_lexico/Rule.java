package analisador_lexico;

import generics.Pair;
import java.util.function.Function;

public class Rule {
    private String pattern;
    private Function<Pair<String, String>, String> translator;

    public Rule(String pattern, Function<Pair<String, String>, String> translator){
        this.pattern = pattern;
        this.translator = translator;
    }
}
