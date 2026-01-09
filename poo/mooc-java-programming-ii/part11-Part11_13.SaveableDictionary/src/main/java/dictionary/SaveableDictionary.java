package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private String file;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file){
        this();
        this.file = file;
    }

    public boolean load(){
        try(Scanner scanner = new Scanner(Paths.get(file))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(":");

                dictionary.put(parts[0], parts[1]);
                dictionary.put(parts[1], parts[0]);
            }

            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void add(String words, String translation){
        dictionary.putIfAbsent(words, translation);
        dictionary.putIfAbsent(translation, words);
    }

    public String translate(String word){
        return dictionary.get(word);
    }

    public void delete(String word){
        String wordTranslated = translate(word);
        dictionary.remove(word);
        dictionary.remove(wordTranslated);
    }

    public boolean save(){
        try(PrintWriter writer = new PrintWriter("file")){
            List<String> word = new ArrayList<>();

            dictionary.forEach((k, v) -> {
                    if(!word.contains(k)){
                        word.add(k);
                        writer.println(k + ": " + v);
                    }
                });

            return true;
        }catch(Exception e){
            return false;
        }
    }
}