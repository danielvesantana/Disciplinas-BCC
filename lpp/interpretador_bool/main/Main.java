package main;

import analisador_lexico.PreProcessor;
import java.util.List;

public class Main {
    public static void main(String[] args){
        PreProcessor reader = new PreProcessor();
        String path = "/home/daniel-alves/gitiznho/Disciplinas-BCC/lpp/interpretador_bool/codigo.bool";

        reader.read_file(path);
        List<String> lines = reader.removeWhiteSpaces();

        
    }
}
