import java.util.ArrayList;

public class Herd implements Movable{
    private ArrayList<Movable> members;

    public Herd(){
        this.members = new ArrayList<>();
    }

    public void addToHerd(Movable movable){
        members.add(movable);
    }

    @Override
    public void move(int dx, int dy){
        for(Movable e : members){
            e.move(dx, dy);
        }
    }

    @Override
    public String toString(){
        String message = "";

        for(Movable e : members){
            message += e.toString() + "\n";
        }

        return message;
    }
}
