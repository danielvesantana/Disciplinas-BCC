package lexical_analysis;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        switch (lexeme) {
            case "class" -> tokens.add(Token.CLASS);
            case "method" -> tokens.add(Token.METHOD);
            case "begin" -> tokens.add(Token.BEGIN);
            case "self" -> tokens.add(Token.SELF);
            case "vars" -> tokens.add(Token.VARS);
            case "end" -> tokens.add(Token.END);
            case "if" -> tokens.add(Token.IF);
            case "else" -> tokens.add(Token.ELSE);
            case "return" -> tokens.add(Token.RETURN);
            case "eq" -> tokens.add(Token.EQ);
            case "ne" -> tokens.add(Token.NE);
            case "lt" -> tokens.add(Token.LT);
            case "le" -> tokens.add(Token.LE);
            case "gt" -> tokens.add(Token.GT);
            case "ge" -> tokens.add(Token.GE);
            case "new" -> tokens.add(Token.NEW);
            case "main" -> tokens.add(Token.MAIN);
            case "io" -> tokens.add(Token.IO);
            case "end-method" -> tokens.add(Token.END_METHOD);
            case "end-class" -> tokens.add(Token.END_CLASS);
            default -> {
                for(Rule rule : rules){
                    if(lexeme.matches(rule.getPattern())){
                        tokens.addAll(rule.getToken().apply(lexeme));
                        return;
                    }
                }
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

    public void createTokenRules(){
        rules.add(new Rule("[a-zA-Z]+$", lr::nameToken));
        rules.add(new Rule("[a-zA-Z]+,$", lr::nameCommaToken));
        rules.add(new Rule("[a-zA-Z]+\\(\\)$", lr::methodNameToken));
        rules.add(new Rule("[a-zA-Z]+\\._prototype$", lr::namePrototypeToken));
        rules.add(new Rule("[a-zA-Z]+\\.[a-zA-Z]+$", lr::nameNameToken));
        rules.add(new Rule("[a-zA-Z]+\\.[a-zA-Z]+\\(\\)$", lr::nameMethodNameToken));
        rules.add(new Rule("([a-zA-Z]+)\\(([^)]*)\\)$", lr::methodNameAtrToken));
        rules.add(new Rule("([a-zA-Z]+)\\.([a-zA-Z]+)\\(([^)]*)\\)$", lr::nameMethodNameAtr));
    }

    public List<Token> tokenize(){
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

        return tokens;
    }

    public void writeTokensFile(){
        try(FileWriter writer = new FileWriter("lexical_analysis/tokens.bool")){
            tokens.stream()
                .forEach(token -> {
                    try {
                        writer.write(token + "\n");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                });
        }catch(FileNotFoundException e) {
            System.out.println("File not founded");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}