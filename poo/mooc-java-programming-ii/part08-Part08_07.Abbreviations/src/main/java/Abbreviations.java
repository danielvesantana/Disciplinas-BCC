import java.util.HashMap;

public class Abbreviations {
    private HashMap<String,String> abreviation;

    public Abbreviations(){
        this.abreviation = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation){
        this.abreviation.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation){
        return this.abreviation.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation){
        if(this.hasAbbreviation(abbreviation)){
            return this.abreviation.get(abbreviation);
        }

        return null;
    }
}
