package lexical_analysis;

import java.util.LinkedList;
import java.util.List;

public class LexerRules {
    private final List<Token> tokens;

    public LexerRules(){
        this.tokens = new LinkedList<>();
    }

    public List<Token> classToken(){
        tokens.add(Token.CLASS);
        return tokens;
    }

    public List<Token> methodToken(){
        tokens.add(Token.METHOD);
        return tokens;
    }

    public List<Token> beginToken(){
        tokens.add(Token.BEGIN);
        return tokens;
    }

    public List<Token> selfToken(){
        tokens.add(Token.SELF);
        return tokens;
    }

    public List<Token> varsToken(){
        tokens.add(Token.VARS);
        return tokens;
    }
    
    public List<Token> endToken(){
        tokens.add(Token.END);
        return tokens;
    }
    
    public List<Token> ifToken(){
        tokens.add(Token.IF);
        return tokens;
    }
    
    public List<Token> elseToken(){
        tokens.add(Token.ELSE);
        return tokens;
    }
    
    public List<Token> returnToken(){
        tokens.add(Token.RETURN);
        return tokens;
    }
    
    public List<Token> eqToken(){
        tokens.add(Token.EQ);
        return tokens;
    }
    
    public List<Token> neToken(){
        tokens.add(Token.NE);
        return tokens;
    }
    
    public List<Token> ltToken(){
        tokens.add(Token.LT);
        return tokens;
    }
    
    public List<Token> leToken(){
        tokens.add(Token.LE);
        return tokens;
    }
    
    public List<Token> gtToken(){
        tokens.add(Token.GT);
        return tokens;
    }
    
    public List<Token> geToken(){
        tokens.add(Token.GE);
        return tokens;
    }
    
    public List<Token> newToken(){
        tokens.add(Token.NEW);
        return tokens;
    }
    
    public List<Token> mainToken(){
        tokens.add(Token.MAIN);
        return tokens;
    }
    
    public List<Token> ioToken(){
        tokens.add(Token.IO);
        return tokens;
    }
    
    public List<Token> end_methodToken(){
        tokens.add(Token.END_METHOD);
        return tokens;
    }
    
    public List<Token> end_classToken(){
        tokens.add(Token.END_CLASS);
        return tokens;
    }
    
    public List<Token> nameToken(){
        tokens.add(Token.NAME);
        return tokens;
    }
    
    public List<Token> nameCommaToken(){
        tokens.add(Token.NAME);
        tokens.add(Token.COMMA);
        return tokens;
    }
    
    public List<Token> methodNameToken(){
        tokens.add(Token.METHOD_NAME);
        tokens.add(Token.LPAREN);
        tokens.add(Token.RPAREN);
        return tokens;
    }
    
    public List<Token> namePrototypeToken(){
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.PROTOTYPE);
        return tokens;
    }
    
    public List<Token> nameNameToken(){
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.NAME);
        return tokens;
    }
    
    public List<Token> nameMethodNameToken(){
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.NAME);
        tokens.add(Token.LPAREN);
        tokens.add(Token.RPAREN);
        return tokens;
    }       
}