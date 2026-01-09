import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> translation;

    public DictionaryOfManyTranslations(){
        this.translation = new HashMap<>();
    }

    public void add(String word, String translation){
        if(!this.translation.containsKey(word)){
            this.translation.put(word, new ArrayList<>());
        }

        this.translation.get(word).add(translation);
    }

    public ArrayList<String> translate(String word){
        if(!(translation.get(word) == null)){
            return translation.get(word);
        }

        return new ArrayList<>();
    }

    public void remove(String word){
        if(this.translation.containsKey(word)){
            this.translation.remove(word);
        }
    }
}
