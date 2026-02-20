package main;

import java.io.IOException;
import java.util.List;
import reader.Reader;

public class Main {
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        String path = "/home/daniel-alves/gitiznho/Disciplinas-BCC/lpp/interpretador_bool/codigo.bool";
        
        reader.read_file(path);
        reader.removeWhiteSpaces();
        List<String> lexemes = reader.getLexemes();
        Lexer lexer = new Lexer(lexemes);
        lexer.tokenize();

        // List<String> lines = reader.getLines();
        // Translation compiler = new Translation(lines);
        //compiler.start();
        
    }
}