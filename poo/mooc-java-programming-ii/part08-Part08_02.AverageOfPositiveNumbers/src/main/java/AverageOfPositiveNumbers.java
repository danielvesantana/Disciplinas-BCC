
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer input;
        int average, count;
        average = count = 0;

        while(!(input = Integer.valueOf(scanner.nextLine())).equals(0)){
            if(input < 0) {
                continue;
            }

            average += input;
            count++;
        }

        if(count != 0){
            System.out.println((average*1.0)/count);
        }else{
            System.out.println("Cannot calculate the average");
        }
    }
}
