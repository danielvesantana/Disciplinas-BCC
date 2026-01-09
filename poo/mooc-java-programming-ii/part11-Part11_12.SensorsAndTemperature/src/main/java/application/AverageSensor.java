package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> averageSensor;
    private List<Integer> readingsData;

    public AverageSensor(){
        this.averageSensor = new ArrayList<>();
        this.readingsData = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd){
        averageSensor.add(toAdd);
    }

    public boolean isOn(){
        for(Sensor sensor : averageSensor){
            if(!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn(){
        averageSensor.stream()
            .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff(){
        averageSensor.stream()
            .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read(){
        if(!isOn() || averageSensor == null){
            throw new IllegalStateException();
        }

        int sum, count, value, average;
        sum = count = 0;
        for(Sensor sensor : averageSensor){
            value = sensor.read();
            sum += value;
            count++;
        }
        average = sum / count;
        readingsData.add(average);

        return average;
    }

    public List<Integer> readings(){
        return readingsData;
    }
}