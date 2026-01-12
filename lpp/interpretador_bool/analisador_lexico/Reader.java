package analisador_lexico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader{
    private List<String> lines;
    private List<String> lexemas;

    public Reader(){
        lines = new LinkedList<>();
        lexemas = new LinkedList<>();
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

    public void remove_white_space(){
        Pattern p = Pattern.compile("\s*([^\s]*)\s*");
        Matcher m;
        for(String line : lines){
            m = p.matcher(line);
        }
    }
}