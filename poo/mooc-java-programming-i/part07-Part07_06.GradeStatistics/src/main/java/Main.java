
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeStatistics input = new GradeStatistics();
        Interface userInterface = new Interface(scanner, input);

        userInterface.menu();
        // Write your program here -- consider breaking the program into 
        // multiple classes.
    }
}
