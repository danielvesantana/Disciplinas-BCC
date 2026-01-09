import java.util.ArrayList;
import java.util.List;

public class Pipe<T> {
    private List<T> elements;

    public Pipe() {
        elements = new ArrayList<>();
    }

    public void putIntoPipe(T toPipe) {
        elements.add(toPipe);
    }

    public T takeFromPipe() {
        T e = elements.get(0);
        elements.remove(0);
        return e;
    }

    public boolean isInPipe() {
        return !elements.isEmpty();
    }
}