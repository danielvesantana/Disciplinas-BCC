package FlightControl.airport;

public class Airplane{
    private String airplaneID;
    private int airplaneCapacity;

    public Airplane(String airplaneID, int airplaneCapacity){
        this.airplaneID = airplaneID;
        this.airplaneCapacity = airplaneCapacity;
    }

    public String getAirplaneID(){
        return airplaneID;
    }

    public int getAirplaneCapacity(){
        return airplaneCapacity;
    }

    public Airplane getAirplane(){
        return this;
    }

    public String toString(){
        return airplaneID + " (" + airplaneCapacity + " capacity)";
    }
}