package main;

import java.io.IOException;
import java.util.Stack;
import reader.Reader;

public class Main {
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        String path = "/home/daniel-alves/gitiznho/Disciplinas-BCC/lpp/interpretador_bool/codigo.bool";
        
        reader.read_file(path);
        reader.removeWhiteSpaces();
        Stack<String> lexemes = reader.getLexemes();

        while(!lexemes.empty()){
            System.out.println(lexemes.pop());
        }

        // List<String> lines = reader.getLines();
        // Translation compiler = new Translation(lines);
        //compiler.start();
        
    }
}