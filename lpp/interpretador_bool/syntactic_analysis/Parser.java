package syntactic_analysis;

import java.util.List;
import lexical_analysis.Token;

public class Parser {
    private final List<Token> tokens;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }
}