public class CD implements Packable{
    private String artist;
    private String CD_name;
    private int publication_year;
    private double weight;

    public CD(String artist, String CD_name, int publication_year){
        this.artist = artist;
        this.CD_name = CD_name;
        this.publication_year = publication_year;
        this.weight = 0.1;
    }

    @Override
    public double weight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return this.artist + ": " + this.CD_name + " (" + this.publication_year + ")";
    }
}
