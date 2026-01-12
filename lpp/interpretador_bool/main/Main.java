package main;

import analisador_lexico.Reader;

public class Main {
    public static void main(String[] args){
        Reader reader = new Reader();
        String path = "/home/daniel-alves/gitiznho/Disciplinas-BCC/lpp/interpretador_bool/codigo.bool";

        reader.read_file(path);
        reader.remove_white_space();
    }
}
