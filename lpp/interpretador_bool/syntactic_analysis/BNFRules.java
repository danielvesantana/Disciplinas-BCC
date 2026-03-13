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
        
        for(int i = index; i < tokens.size(); i++){
            if(tokens.get(i) == Token.NAME && 
               tokens.get(i+1) == Token.COMMA && 
               tokens.get(i+2) == Token.NAME){
                bnfList.add(tokens.get(i));
                bnfList.add(tokens.get(i+1));
                bnfList.add(tokens.get(i+2));
            }else if(tokens.get(i) == Token.NAME){
                bnfList.add(tokens.get(i));
            }
        }

        return bnfList;
    }

    public List<Token> ifBNF(List<Token> tokens, int index) {
    }

    public List<Token> elseBNF(List<Token> tokens, int index) {
    }

    public List<Token> returnBNF(List<Token> tokens, int index) {
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
}