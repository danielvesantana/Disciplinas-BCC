import java.util.ArrayList;

public class Box implements Packable{
    private double capacity;
    private ArrayList<Packable> box;

    public Box(double capacity){
        this.capacity = capacity;
        this.box = new ArrayList<>();
    }

    public void add(Packable item){
        if(this.weight() + item.weight() <= this.capacity){
            this.box.add(item);
        }
    }

    @Override
    public double weight(){
        if(box.isEmpty()){
            return 0.0;
        }

        double weight = 0;
        for(Packable e : box){
            weight += e.weight();
        }

        return weight;
    }

    @Override
    public String toString(){
        return "Box: " + box.size() + " items, total weight " + this.weight() + " kg";
    }
}
