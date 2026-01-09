package FlightControl.airport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Control{
    private HashMap<Airplane, Flight> controlFlight;
    private List<Airplane> airplanes;
    private List<Flight> flights;

    public Control(){
        controlFlight = new HashMap<>();
        airplanes = new ArrayList<>();
        flights = new ArrayList<>();
    }

    public Airplane getAirplane(String airplaneID){
        return airplanes.stream()
            .filter(airplane -> airplane.getAirplaneID().equals(airplaneID))
            .map(Airplane::getAirplane)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Airplane not found: " + airplaneID));
    }

    public void addAirplane(Airplane airplane){
        airplanes.add(airplane);
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void addControlFlight(Airplane airplane, Flight flight){
        controlFlight.put(airplane, flight);
    }

    public void printAirplanes(){
        airplanes.forEach(airplane -> System.out.println(airplane));
    }

    public void printFlights(){
        flights.forEach(flight -> System.out.println(flight));
    }

    public void printAirplaneDetails(String airplaneID){
        airplanes.stream()
                .map(airplane -> airplane.getAirplaneID().equals(airplaneID))
                .forEach(airplane -> System.out.println(airplane.toString()));
    }
}