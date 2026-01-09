import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item){
        int weight = 0;
        for(Item e : items){
            weight += e.getWeight();
        }
        weight += item.getWeight();

        if(weight <= this.capacity){
            items.add(item);
        }
    }

    public boolean isInBox(Item item){
        if(items.contains(item)){
            return true;
        }

        return false;
    }
}
