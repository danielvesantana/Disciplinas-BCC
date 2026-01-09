
import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> register;
    
    public VehicleRegistry(){
        this.register = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner){
        if(register.get(licensePlate) == null){
            register.put(licensePlate, owner);
            return true;
        }else{
            return false;
        }
    }

    public String get(LicensePlate licensePlate){
        for(LicensePlate key : register.keySet()){
            if (key.equals(licensePlate)) {
                return register.get(key);
            }
        }

        return null;
    }

    public boolean remove(LicensePlate licensePlate){
        if (register.containsKey(licensePlate)) {
            register.remove(licensePlate);

            return true;
        }

        return false;
    }

    public void printLicensePlates(){
        for (LicensePlate key : register.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners(){
        ArrayList<String> owners = new ArrayList<>();
        
        for(LicensePlate key : register.keySet()){
            boolean flag = false;

            for(int i = 0; i < owners.size(); i++){
                if(register.get(key).equals(owners.get(i))){
                    flag = true;
                }
            }

            if(!flag){
                System.out.println(register.get(key));

                owners.add(register.get(key));
            }
        }
    }
}