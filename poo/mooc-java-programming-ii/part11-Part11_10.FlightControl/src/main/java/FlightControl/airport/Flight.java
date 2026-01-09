package FlightControl.airport;

public class Flight{
    private Airplane airplane;
    private String departureAirportID;
    private String targetAirportID;

    public Flight(Airplane airplane, String departureAirportID, String targetAirportID){
        this.airplane = airplane;
        this.departureAirportID = departureAirportID;
        this.targetAirportID = targetAirportID;
    }

    public String getDepartureAirportID(){
        return departureAirportID;
    }

    public String getTargetAirportID(){
        return targetAirportID;
    }

    public String toString(){
        return airplane.getAirplaneID() + " (" + airplane.getAirplaneCapacity() + " capacity) " +
        "(" + departureAirportID + "-" + targetAirportID + ")";
    }
}