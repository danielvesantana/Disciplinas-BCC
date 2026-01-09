import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here
        
        List<String> numbers = new ArrayList<>();
        while(true){
            String message = scanner.nextLine();

            if(message.equals("end")){
                break;
            }

            numbers.add(message);            
        }

        double average = numbers.stream()
            .mapToInt(s -> Integer.valueOf(s))
            .average()
            .getAsDouble();

        System.out.println(average);
    }
}
