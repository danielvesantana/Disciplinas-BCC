
import java.util.ArrayList;
import java.util.Collections;

public class Database {
    private ArrayList<Bird> birds;

    public Database(){
        this.birds = new ArrayList<Bird>();
    }

    public void Add(Bird bird){
        this.birds.add(bird);
    }

    public void addObservation(String name){
        for(Bird element : birds){
            if(element.getName().equals(name)){
                element.addObservation();
                return;
            }
        }
        System.out.println("Not a bird!");
    }

    public void printBirds(){
    Collections.reverse(birds);
        for(Bird element : birds){
            System.out.println(element.toString());   
        }
    }

    public void printBird(String name){
        for(Bird element : birds){
            if(element.getName().equals(name)){
                System.out.println(element.toString());
            }
        }
    }
}
