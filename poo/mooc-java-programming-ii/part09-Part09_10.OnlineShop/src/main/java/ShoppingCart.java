
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items;

    public ShoppingCart(){
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        if(!items.containsKey(product)){
            items.put(product, new Item(product, 0, price));
        }
        items.get(product).increaseQuantity();
    }

    public int price(){
        int totalPrice = 0;

        for (String key : items.keySet()) {
            totalPrice += items.get(key).price();
        }

        return totalPrice;
    }

    public void print(){
        for (String key : items.keySet()){
            System.out.println(items.get(key).toString());
        }
    }
}
