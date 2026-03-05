package syntactic_analysis;

import java.util.List;

public class Parser {
    private final List<String> tokens;

    public Parser(List<String> tokens){
        this.tokens = tokens;
    }

    public void Parsing(){
        tokens.stream()
            .forEach(token -> System.out.println(token));
    }
}