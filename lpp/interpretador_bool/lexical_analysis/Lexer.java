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
        for(Rule rule : rules){
            if(lexeme.matches(rule.getPattern())){
                tokens.addAll();
            }
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

    public void createRules(){
        rules.add(new Rule("class", lr::classToken));
        rules.add(new Rule("method", lr::methodToken));
        rules.add(new Rule("begin", lr::beginToken));
        rules.add(new Rule("self", lr::selfToken));
        rules.add(new Rule("vars", lr::varsToken));
        rules.add(new Rule("end", lr::endToken));
        rules.add(new Rule("if", lr::ifToken));
        rules.add(new Rule("else", lr::elseToken));
        rules.add(new Rule("return", lr::returnToken));
        rules.add(new Rule("eq", lr::eqToken));
        rules.add(new Rule("ne", lr::neToken));
        rules.add(new Rule("lt", lr::ltToken));
        rules.add(new Rule("le", lr::leToken)); 
        rules.add(new Rule("gt", lr::gtToken));
        rules.add(new Rule("ge", lr::geToken));
        rules.add(new Rule("new", lr::newToken));
        rules.add(new Rule("main", lr::mainToken));
        rules.add(new Rule("io", lr::ioToken));
        rules.add(new Rule("end-method", lr::end_methodToken));
        rules.add(new Rule("end-class", lr::end_classToken));
        rules.add(new Rule("[a-zA-Z]+", lr::nameToken));
        rules.add(new Rule("[a-zA-Z]+,", lr::nameCommaToken));
        rules.add(new Rule("[a-zA-Z]+()", lr::methodNameToken));
        rules.add(new Rule("[a-zA-Z]+._prototype", lr::namePrototypeToken));
        rules.add(new Rule("[a-zA-Z]+.[a-zA-Z]+", lr::nameNameToken));
        rules.add(new Rule("[a-zA-Z]+.[a-zA-Z]+()", lr::nameMethodNameToken));
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