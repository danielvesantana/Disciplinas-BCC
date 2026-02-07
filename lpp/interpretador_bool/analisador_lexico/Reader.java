package analisador_lexico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader{
    private final List<String> lines;
    private final List<String> linePreProcessed;

    public Reader(){
        lines = new LinkedList<>();
        linePreProcessed = new LinkedList<>();
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

    public List<String> removeWhiteSpaces(){
        String str;
        for(String line : lines){
            if(line.isEmpty()){continue;}
            str = line.replaceAll("[\\s]{2,}", "");

            linePreProcessed.add(str);
        }

        return linePreProcessed;
    }

    
}