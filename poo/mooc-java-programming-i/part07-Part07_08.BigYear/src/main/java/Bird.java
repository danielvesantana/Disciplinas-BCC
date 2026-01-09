public class Bird {
    private String name;
    private String nameInLatin;
    private int numberObservation;

    public Bird(String name, String nameInLatin){
        this.name = name;
        this.nameInLatin = nameInLatin;
        this.numberObservation = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLatinName(){
        return nameInLatin;
    }

    public void setLatinName(String nameInLatin){
        this.nameInLatin = nameInLatin;
    }

    public void addObservation(){
        this.numberObservation++;
    }

    public String toString(){
        return this.name + " (" + this.nameInLatin + "): " + this.numberObservation + " observations";
    }
}
