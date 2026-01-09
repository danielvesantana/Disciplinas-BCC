import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random(); 

        System.out.println("How many random numbers should be printed?");
        int number = Integer.parseInt(scanner.nextLine());
        
        for(int i = 0; i < number; i++){
            System.out.println(randomNumber.nextInt(11)); 
        }
    }

}
