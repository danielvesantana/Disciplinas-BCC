import java.util.ArrayList;
import java.util.List;

public class Hideout<T>{
    private List<T> elements;

    public Hideout(){
        elements = new ArrayList<>();
    }

    public void putIntoHideout(T toHide){
        elements.add(toHide);
    }

    public T takeFromHideout(){
        T e = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);

        return e;
    }

    public boolean isInHideout() {
        return !elements.isEmpty();
    }
}