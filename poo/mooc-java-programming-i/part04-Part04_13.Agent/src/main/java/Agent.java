public class Agent{
    private String first_name;
    private String last_name;

    public Agent(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String toString(){
        return "My name is " + last_name + ", " + first_name + " " + last_name;
    }
}
