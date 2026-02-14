package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Reader{
    private final List<String> lines;
    private final List<String> linePreProcessed;
    private final Stack<String> lexemes;

    public Reader(){
        lines = new LinkedList<>();
        linePreProcessed = new LinkedList<>();
        lexemes = new Stack<>();
    }

    public void read_file(String path){
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            String line;
            while((line = in.readLine()) != null){
                lines.add(line);
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void removeWhiteSpaces(){
        String str;
        for(String line : lines){
            if(line.isEmpty()){continue;}
            str = line.replaceAll("[\\s]{2,}", "");

            linePreProcessed.add(str);
        }
    }

    public List<String> getLines(){
        if(linePreProcessed.isEmpty()){
            removeWhiteSpaces();
        }

        return linePreProcessed;
    }

    public Stack<String> getLexemes(){
        for(String line : linePreProcessed){
            String[] lex = line.split(" ");

            Collections.reverse(Arrays.asList(lex));
            lexemes.addAll(Arrays.asList(lex));
        }

        return lexemes;
    }
}