import java.util.Scanner;

public class RepeatingBreakingAndRemembering{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int input = 0, sum = 0, numbers = 0, even = 0, odd = 0;
        double average = 0.0;

        System.out.println("Give numbers:");
        while(true){
            input = scanner.nextInt();

            if(input == -1){
                break;
            }

            sum += input;
            numbers++;
            
            if(input % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }

        average = sum/(double)numbers;

        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numbers);
        System.out.println("Average: " + average);
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}