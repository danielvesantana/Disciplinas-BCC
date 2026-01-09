import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        System.out.println("Input numbers, type \"end\" to stop.");
        List<String> numbers = new ArrayList<>();
        while(true){
            String message = scanner.nextLine();

            if(message.equals("end")){
                break;
            }

            numbers.add(message);            
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String signal = scanner.nextLine();

        if(signal.equals("n")){
            double negAverage = numbers.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> number < 0)
                .average()
                .getAsDouble();
                System.out.println("Average of the negative numbers:" + negAverage);
        }else if(signal.equals("p")){
            double posAverage = numbers.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .filter(number -> number >= 0)
                .average()
                .getAsDouble();
                System.out.println("Average of the positive numbers:" + posAverage);
        }   
    }
}