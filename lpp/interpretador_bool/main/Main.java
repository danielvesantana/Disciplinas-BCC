package main;

import analisador_lexico.Compiler;
import analisador_lexico.Reader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        String path = "/home/daniel-alves/gitiznho/Disciplinas-BCC/lpp/interpretador_bool/codigo.bool";
        
        reader.read_file(path);
        List<String> lines = reader.removeWhiteSpaces();
        Compiler compiler = new Compiler(lines);
        compiler.start();
        
    }
}