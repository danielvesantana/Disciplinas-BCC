package lexical_analysis;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import intermediate_code.Rule;

public class Lexer {
    private final List<String> lexemes;
    private final List<Token> tokens;
    private final List<Rule> rules;
    private final LexerRules lr;

    public Lexer(List<String> lexemes){
        this.lexemes = lexemes;
        this.tokens = new LinkedList<>();
        this.rules = new LinkedList<>();
        this.lr = new LexerRules();
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
        if (lexeme.equals("class")) {
            tokens.add(Token.CLASS);
        }else if (lexeme.equals("method")) {
            tokens.add(Token.METHOD);
        }else if (lexeme.equals("begin")) {
            tokens.add(Token.BEGIN);
        }else if (lexeme.equals("self")) {
            tokens.add(Token.SELF);
        }else if (lexeme.equals("vars")) {
            tokens.add(Token.VARS);
        }else if (lexeme.equals("end")) {
            tokens.add(Token.END);
        }else if (lexeme.equals("if")) {
            tokens.add(Token.IF);
        }else if (lexeme.equals("else")) {
            tokens.add(Token.ELSE);
        }else if (lexeme.equals("return")) {
            tokens.add(Token.RETURN);
        }else if (lexeme.equals("eq")) {
            tokens.add(Token.EQ);
        }else if (lexeme.equals("ne")) {
            tokens.add(Token.NE);
        }else if (lexeme.equals("lt")) {
            tokens.add(Token.LT);
        }else if (lexeme.equals("le")) {
            tokens.add(Token.LE);
        }else if (lexeme.equals("gt")) {
            tokens.add(Token.GT);
        }else if (lexeme.equals("ge")) {
            tokens.add(Token.GE);
        }else if (lexeme.equals("new")) {
            tokens.add(Token.NEW);
        }else if (lexeme.equals("main")) {
            tokens.add(Token.MAIN);
        }else if (lexeme.equals("io")) {
            tokens.add(Token.IO);
        }else if (lexeme.equals("end-method")) {
            tokens.add(Token.END_METHOD);
        }else if (lexeme.equals("end-class")) {
            tokens.add(Token.END_CLASS);
        }

        for(Rule rule : rules){
            if(lexeme.matches(rule.getPattern())){
                tokens.addAll(rule.getToken().apply(lexeme));
            }
        }
    }

    public void isNumber(String lexeme){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(lexeme);

        if(m.matches()){
            tokens.add(Token.NUMBER);
        }else{
            System.out.println(lexeme + " não é um identificador válido");
        }
    }

    public void isOperation(String lexeme){
        switch(lexeme){
            case "=" -> tokens.add(Token.OP_ASSIGN);
            case "+" -> tokens.add(Token.OP_SUM);
            case "*" -> tokens.add(Token.OP_MULTIPLICATION);
            case "-" -> tokens.add(Token.OP_SUBTRACTION);
            case "/" -> tokens.add(Token.OP_DIVISION);
            default -> {}
            }
    }

    public void createRules(){
        rules.add(new Rule("[a-zA-Z]+", lr::nameToken));
        rules.add(new Rule("[a-zA-Z]+,", lr::nameCommaToken));
        rules.add(new Rule("[a-zA-Z]+()", lr::methodNameToken));
        rules.add(new Rule("[a-zA-Z]+._prototype", lr::namePrototypeToken));
        rules.add(new Rule("[a-zA-Z]+.[a-zA-Z]+", lr::nameNameToken));
        rules.add(new Rule("[a-zA-Z]+.[a-zA-Z]+()", lr::nameMethodNameToken));
        rules.add(new Rule("([a-zA-Z]+)\\(([^)]*)\\)", lr::methodNameAtrToken));
        rules.add(new Rule("([a-zA-Z]+)\\.([a-zA-Z]+)\\(([^)]*)\\)", lr::nameMethodNameAtr));
    }

    public void tokenize(){
        createRules();

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