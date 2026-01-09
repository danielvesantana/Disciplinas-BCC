import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory(){
        history = new ArrayList<>();
    }

    public void add(double status){
        this.history.add(status);
    }

    public void clear(){
        this.history.clear();
    }

    public double maxValue(){
        if(this.history.isEmpty()){
            return 0.0;
        }

        double maximun = 0.0; 
        for(int i = 0; i < history.size(); i++){
            if(this.history.get(i) > maximun){
                maximun = this.history.get(i);
            }
        }

        return maximun;
    }

    public double minValue(){
        if(this.history.isEmpty()){
            return 0.0;
        }

        double minimum = Integer.MAX_VALUE;
        for(int i = 0; i < history.size(); i++){
            if(this.history.get(i) < minimum){
                minimum = this.history.get(i);
            }
        }

        return minimum;
    }

    public double average(){
        if(this.history.isEmpty()){
            return 0.0;
        }

        double average = 0.0;
        for(int i = 0; i < this.history.size(); i++){
            average += this.history.get(i);
        }

        average /= this.history.size();

        return average;
    }

    @Override
    public String toString(){
        return this.history.toString();
    }
}