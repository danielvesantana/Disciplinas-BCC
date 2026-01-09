package FlightControl;

import FlightControl.ui.TextUI;
import FlightControl.airport.Control;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Control flightControl = new Control();
        TextUI ui = new TextUI(flightControl, scanner);

        ui.start();
    }
}
