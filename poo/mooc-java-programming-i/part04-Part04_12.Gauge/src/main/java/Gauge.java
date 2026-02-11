public class Gauge{
    private int value;

    public Gauge() {
        this.value = 0;
    }

    public void increase(){
        this.value = this.value + 1;
    }

    public void decrease(){
        this.value = this.value - 1;
    }

    public int value(){
        return value;
    }

    public boolean full(){
        if(this.value == 5)
            return true;
        else
            return false;
    }
}
