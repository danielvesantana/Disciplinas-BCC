package FlightControl.ui;

import java.util.Scanner;

import FlightControl.airport.Airplane;
import FlightControl.airport.Control;
import FlightControl.airport.Flight;

public class TextUI{
    private Scanner scanner;
    private Control flightControl;

    public TextUI(Control flightControl, Scanner scanner){
        this.scanner = scanner;
        this.flightControl = flightControl;
    }

    public void start(){
        startAirportAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    public void startAirportAssetControl(){
        Boolean flag = false;

        while(true){
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control" + "\n" + ">");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addAirplane();
                    break;
                case "2":
                    addFlight();
                    break;
                case "x":
                    flag = true;
                    break;
                default:
                    break;
            }

            if(flag){
                break;
            }
        }
    }

    private void addAirplane(){
        System.out.println("Give the airplane id: ");
        String airplaneID = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");    
        int airplaneCapacity = Integer.parseInt(scanner.nextLine());

        flightControl.addAirplane(new Airplane(airplaneID, airplaneCapacity));
    }

    private void addFlight(){
        System.out.println("Give the airplane id: ");
        String airplaneID = scanner.nextLine();
        System.out.println("Give the departure airport id:");
        String departureAirportID = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String targetAirportID = scanner.nextLine();

        Airplane airplane = flightControl.getAirplane(airplaneID);
        Flight flight = new Flight(airplane, departureAirportID, targetAirportID);

        flightControl.addFlight(flight);
        flightControl.addControlFlight(airplane, flight);
    }

    public void startFlightControl(){
        Boolean flag = false;
        while(true){
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit" + "\n" + ">");
            String option = scanner.nextLine();

            switch(option){
                case "1":
                    flightControl.printAirplanes();
                    break;
                case "2":
                    flightControl.printFlights();
                    break;
                case "3":
                    System.out.println("Give the airplane id: ");
                    String airplaneID = scanner.nextLine();
                    flightControl.printAirplaneDetails(airplaneID);
                    break;
                case "x":
                    flag = true;
                    break;
            }

            if(flag){
                break;
            }
        }
    }
}