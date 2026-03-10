package main;

import java.io.IOException;
import java.util.List;
import lexical_analysis.Lexer;
import lexical_analysis.Token;
import reader.Reader;
import syntactic_analysis.Parser;

public class Main {
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        String source_code_path = "codigo.bool";
        String tokens_code_path = "lexical_analysis/tokens.bool";
        
        reader.read_file(source_code_path);
        reader.removeWhiteSpaces();
        List<String> lexemes = reader.getStrings();
        Lexer lexer = new Lexer(lexemes);
        lexer.createTokenRules();
        List<Token> tokens = lexer.tokenize();
        lexer.writeTokensFile();
        reader.read_file(tokens_code_path);
        Parser parser = new Parser(tokens);

        // tokens.stream()
        //       .forEach(token -> System.out.println(token));
        // List<String> lines = reader.getLines();
        // Translation compiler = new Translation(lines);
        //compiler.start();
        
    }
}