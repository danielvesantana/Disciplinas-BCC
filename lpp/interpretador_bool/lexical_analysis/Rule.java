package lexical_analysis;

import java.util.List;
import java.util.function.Function;

public class Rule {
    private final Function<String, List<Token>> createToken;
    private final String pattern;

    public Rule(String pattern, Function<String, List<Token>> createToken){
        this.pattern = pattern;
        this.createToken = createToken;
    }

    public String getPattern(){
        return pattern;
    }

    public Function<String, List<Token>> getToken(){
        return createToken;
    }
}
