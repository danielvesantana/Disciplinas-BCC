import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> warehouseStocks;
    private Map<String, Integer> warehousePrice;

    public Warehouse(){
        this.warehouseStocks = new HashMap<String,Integer>();
        this.warehousePrice = new HashMap<String,Integer>();
    }

    public void addProduct(String product, int price, int stock){
        this.warehouseStocks.put(product, stock);
        this.warehousePrice.put(product, price);
    }

    public int price(String product){
        if (this.warehousePrice.containsKey(product)) {
            return this.warehousePrice.get(product);
        }

        return -99;
    }

    public int stock(String product){
        if(this.warehouseStocks.containsKey(product)){
            return this.warehouseStocks.get(product);
        }

        return 0;
    }

    public boolean take(String product){
        if(stock(product) > 0){
            warehouseStocks.put(product, warehouseStocks.get(product) - 1);

            if(stock(product) > 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public Set<String> products(){
        return this.warehouseStocks.keySet();
    }
}
