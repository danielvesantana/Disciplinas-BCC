package syntactic_analysis;

import java.util.List;
import lexical_analysis.Token;

public class Parser {
    private final List<Token> tokens;
    private final BNFRules bnfRules;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
        this.bnfRules = new BNFRules();
    }

    public void bnfTokens(){
        for(int i = 0; i < tokens.size(); ++i){
            findBnfRule(tokens.get(i), i);
        }
    }

    public void findBnfRule(Token token, int index){
        switch(token){
            case CLASS -> bnfRules.classBNF(tokens, index);
            case METHOD -> bnfRules.methodBNF(tokens, index);
            case BEGIN -> bnfRules.beginBNF(tokens, index);
            case SELF -> bnfRules.selfBNF(tokens, index);
            case VARS -> bnfRules.varsBNF(tokens, index);
            case IF -> bnfRules.ifBNF(tokens, index);
            case ELSE -> bnfRules.elseBNF(tokens, index);
            case NEW -> bnfRules.newBNF(tokens, index);
            case MAIN -> bnfRules.mainBNF(tokens, index);
            case IO -> bnfRules.ioBNF(tokens, index);
            case NAME -> bnfRules.nameBNF(tokens, index);
            case LPAREN -> bnfRules.lparenBNF(tokens, index);
            case RPAREN -> bnfRules.rparenBNF(tokens, index);
            case DOT -> bnfRules.dotBNF(tokens, index);
            case COMMA -> bnfRules.commaBNF(tokens, index);
            case PROTOTYPE -> bnfRules.prototypeBNF(tokens, index);
            case METHOD_NAME -> bnfRules.methodNameBNF(tokens, index);
            default -> {
                System.out.println("Token inválido");
                return;
            }
        }
    }
}