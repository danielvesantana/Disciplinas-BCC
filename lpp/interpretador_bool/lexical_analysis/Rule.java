package lexical_analysis;

import java.util.List;
import java.util.function.Function;
import generics.Pair;

public class Rule {
    private final Function<Pair<String, String>, List<Token>> createToken;
    private final String pattern;

    public Rule(String pattern, Function<Pair<String, String>> createToken){
        this.pattern = pattern;
        this.createToken = createToken;
    }

    public String getPattern(){
        return pattern;
    }

    public Function<Pair<String, String>> getToken(){
        return token;
    }
}
