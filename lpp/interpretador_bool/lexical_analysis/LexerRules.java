package lexical_analysis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerRules {
    public List<Token> nameToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.NAME);
        return tokens;
    }
    
    public List<Token> nameCommaToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.NAME);
        tokens.add(Token.COMMA);
        return tokens;
    }
    
    public List<Token> methodNameToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.METHOD_NAME);
        tokens.add(Token.LPAREN);
        tokens.add(Token.RPAREN);
        return tokens;
    }
    
    public List<Token> namePrototypeToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.PROTOTYPE);
        return tokens;
    }
    
    public List<Token> nameNameToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.NAME);
        return tokens;
    }
    
    public List<Token> nameMethodNameToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.NAME);
        tokens.add(Token.LPAREN);
        tokens.add(Token.RPAREN);
        return tokens;
    }       

    public List<Token> methodNameAtrToken(String lexeme){
        List<Token> tokens = new LinkedList<>();
        List<Token> atr = getMatcherGroup("([a-zA-Z]+)", lexeme);
        tokens.add(Token.METHOD_NAME);
        tokens.add(Token.LPAREN);
        tokens.addAll(atr);
        tokens.add(Token.RPAREN);

        return tokens;
    }

    public List<Token> nameMethodNameAtr(String lexeme){
        List<Token> tokens = new LinkedList<>();
        List<Token> atr = getMatcherGroup("([a-zA-Z]+)", lexeme);
        tokens.add(Token.NAME);
        tokens.add(Token.DOT);
        tokens.add(Token.METHOD_NAME);
        tokens.add(Token.LPAREN);
        tokens.addAll(atr);
        tokens.add(Token.RPAREN);

        return tokens;
    }

    public List<Token> getMatcherGroup(String pattern, String line){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        List<Token> matcher = new ArrayList<>();

        if(m.matches()){
            for(int i = 0; i <= m.groupCount(); i++){
                matcher.add(Token.NAME);
            }
        }

        return matcher;
    }
}