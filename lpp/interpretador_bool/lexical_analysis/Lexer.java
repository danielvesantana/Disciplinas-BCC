package lexical_analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private final List<String> lexemes;
    private final List<Token> tokens;

    public Lexer(List<String> lexemes){
        this.lexemes = lexemes;
        this.tokens = new LinkedList<>();
    }

    public boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public boolean isDigit(char c){
        return (c >= '0' && c <= '9');
    }

    public boolean isSymbol(char c){
        return (c == '=' ||
                c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/'
        );
    }

    public void isIdentifier(String lexeme){
        Pattern p1 = Pattern.compile("[a-zA-Z]+");
        Pattern p2 = Pattern.compile("[a-zA-Z]+,");
        Pattern p3 = Pattern.compile("[a-zA-Z]+()");
        Pattern p4 = Pattern.compile("[a-zA-Z]+._prototype");
        Pattern p5 = Pattern.compile("[a-zA-Z]+.[a-zA-Z]+");
        Matcher m1 = p1.matcher(lexeme);
        Matcher m2 = p2.matcher(lexeme);
        Matcher m3 = p3.matcher(lexeme);
        Matcher m4 = p4.matcher(lexeme);
        Matcher m5 = p5.matcher(lexeme);
        Token token;
        if(lexeme.equals("class")){
            token = Token.CLASS;
            tokens.add(token);
        }else if(lexeme.equals("method")){
            token = Token.METHOD;
            tokens.add(token);
        }else if(lexeme.equals("begin")){
            token = Token.BEGIN;
            tokens.add(token);
        }else if(lexeme.equals("self")){
            token = Token.SELF;
            tokens.add(token);
        }else if(lexeme.equals("vars")){
            token = Token.VARS;
            tokens.add(token);
        }else if(lexeme.equals("end")){
            token = Token.END;
            tokens.add(token);
        }else if(lexeme.equals("if")){
            token = Token.IF;
            tokens.add(token);
        }else if (lexeme.equals("else")) {
            token = Token.ELSE;
            tokens.add(token);
        }else if(lexeme.equals("return")){
            token = Token.RETURN;
            tokens.add(token);
        }else if(lexeme.equals("eq")){
            token = Token.EQ;
            tokens.add(token);
        }else if(lexeme.equals("ne")){
            token = Token.NE;
            tokens.add(token);
        }else if(lexeme.equals("lt")){
            token = Token.LT;
            tokens.add(token);
        }else if(lexeme.equals("le")){
            token = Token.LE;
            tokens.add(token);
        }else if(lexeme.equals("gt")){
            token = Token.GT;
            tokens.add(token);
        }else if(lexeme.equals("ge")){
            token = Token.GE;
            tokens.add(token);
        }else if(lexeme.equals("new")){
            token = Token.NEW;
            tokens.add(token);
        }else if(lexeme.equals("main")){
            token = Token.MAIN;
            tokens.add(token);
        }else if(lexeme.equals("io")){
            token = Token.IO;
            tokens.add(token);
        }else if(lexeme.equals("end-method")){
            token = Token.END_METHOD;
            tokens.add(token);
        }else if(lexeme.equals("end-class")){
            token = Token.END_CLASS;
            tokens.add(token);
        }else if (m1.matches()) {
            token = Token.NAME;
            tokens.add(token);
        }else if (m2.matches()) {
            Token token1 = Token.COMMA;
            token = Token.NAME;
            tokens.add(token);
            tokens.add(token1);
        }else if (m3.matches()) {
            token = Token.METHOD_NAME;
            tokens.add(token);
        }else if (m4.matches()){
            Token token1 = Token.PROTOTYPE;
            token = Token.NAME;
            tokens.add(token);
            tokens.add(token1);
        }else if (m5.matches()) {
            Token token1 = Token.NAME;
            Token token2 = Token.COMMA;
            token = token.NAME;
            tokens.add(token1);
            tokens.add(token2);
            tokens.add(token);
        }else{
            System.out.println(lexeme + " não é um identificador válido");
        }
    }

    public void isNumber(String lexeme){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(lexeme);
        Token token;

        if(m.matches()){
            token = Token.NUMBER;
            tokens.add(token);
        }else{
            System.out.println(lexeme + " não é um identificador válido");
        }
    }

    public void isOperation(String lexeme){
        Token token;
        switch(lexeme){
            case "=" -> token = Token.OP_ASSIGN;
            case "+" -> token = Token.OP_SUM;
            case '*' -> token = Token.OP_MULTIPLICATION;
            case "-" -> token = Token.OP_SUBTRACTION;
            case "/" -> token = Token.OP_DIVISION;
            default -> {}
            }
    }

    public void tokenize(){
        char c;
        for(String lexeme : lexemes){
            c = lexeme.charAt(0);

            if(isLetter(c)){
                isIdentifier(lexeme);
            }else if(isDigit(c)){
                isNumber(lexeme);
            }else if(isSymbol(c)){
                isOperation(lexeme);
            }else{
                System.out.println(lexeme + " não é um identificador válido");
            }
        }
    }
}