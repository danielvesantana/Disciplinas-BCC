import java.util.Scanner;

public class SumOfNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int result, a;

        result = 0;
        do{
            System.out.println("Give a number:");
            a = scanner.nextInt();

            result += a;
        }while(a != 0);        

        System.out.println("Sum of the numbers: " + result);               
    }
}