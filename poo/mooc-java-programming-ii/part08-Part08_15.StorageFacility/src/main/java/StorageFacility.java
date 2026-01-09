import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility(){
        storage = new HashMap<>();
    }

    public void add(String unit, String item){
        if(!this.storage.containsKey(unit)){
            this.storage.put(unit, new ArrayList<>());
        }

        this.storage.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit){
        if (this.storage.containsKey(storageUnit)) {
            return this.storage.get(storageUnit);
        }

        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item){
        if(this.storage.containsKey(storageUnit)){
            this.storage.get(storageUnit).remove(item);
        }

        if(this.storage.get(storageUnit).isEmpty()){
            this.storage.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits(){
        ArrayList<String> names = new ArrayList<>();

        for(String key : storage.keySet()){
            names.add(key);
        }

        return names;
    }
}
