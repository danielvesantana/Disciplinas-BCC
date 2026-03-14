package syntactic_analysis;

import java.util.LinkedList;
import java.util.List;
import lexical_analysis.Token;

public class BNFRules {
    public List<Token> classBNF(List<Token> tokens, int index) {
    }

    public List<Token> methodBNF(List<Token> tokens, int index) {
    }
    
    public List<Token> beginBNF(List<Token> tokens, int index) {
    }
    
    public List<Token> selfBNF(List<Token> tokens, int index) {
    }

    public List<Token> varsBNF(List<Token> tokens, int index) {
        List<Token> bnfList = new LinkedList<>();
        bnfList.add(tokens.get(index));
        
        int i = index;
        if(tokens.get(i) == Token.NAME && 
            tokens.get(i+1) == Token.COMMA && 
            tokens.get(i+2) == Token.NAME){
            bnfList.add(tokens.get(i));
            bnfList.add(tokens.get(i+1));
            bnfList.add(tokens.get(i+2));
        }else if(tokens.get(i) == Token.NAME){
            bnfList.add(tokens.get(i));
        }

        return bnfList;
    }

    public List<Token> ifBNF(List<Token> tokens, int index) {
        List<Token> bnfList = new LinkedList<>();
        bnfList.add(tokens.get(index));

        int i = index;
        if(tokens.get(i) == Token.IF &&
            tokens.get(i+1) == Token.NAME &&
            cmp(tokens.get(i+2)) &&
            tokens.get(i+3) == Token.NAME &&
            tokens.get(i+4) == Token.THEN &&
            ifStmts(tokens.get(i+5)) &&
            tokens.get(i+6) == Token.END_IF){
                
            }
    }

    public List<Token> elseBNF(List<Token> tokens, int index) {
    }

    public List<Token> newBNF(List<Token> tokens, int index) {
    }

    public List<Token> mainBNF(List<Token> tokens, int index) {
    }

    public List<Token> ioBNF(List<Token> tokens, int index) {
    }

    public List<Token> nameBNF(List<Token> tokens, int index) {
    }

    public List<Token> lparenBNF(List<Token> tokens, int index) {
    }

    public List<Token> rparenBNF(List<Token> tokens, int index) {
    }

    public List<Token> dotBNF(List<Token> tokens, int index) {
    }

    public List<Token> commaBNF(List<Token> tokens, int index) {
    }

    public List<Token> prototypeBNF(List<Token> tokens, int index) {
    }

    public List<Token> methodNameBNF(List<Token> tokens, int index) {
    }

    public Boolean cmp(Token token){
        return token == Token.EQ ||
               token == Token.NE ||
               token == Token.GT ||
               token == Token.GE ||
               token == Token.LT ||
               token == Token.LE;    
    }
}