package application;
import java.util.Random;

public class TemperatureSensor implements Sensor{
    private Random randomNumber;
    private int state;

    public TemperatureSensor(){
        this.randomNumber = new Random();
        this.state = 0;
    }

    @Override
    public boolean isOn(){
        if(state == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void setOn(){
        state = 1;
    }

    @Override
    public void setOff(){
        state = 0;
    }

    @Override
    public int read(){
        if(!isOn()){
            throw new IllegalStateException();
        }
        
        return randomNumber.nextInt(-30, 30);
    }
}