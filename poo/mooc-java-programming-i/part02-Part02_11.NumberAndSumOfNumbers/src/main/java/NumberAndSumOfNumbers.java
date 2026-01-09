import java.util.Scanner;

public class NumberAndSumOfNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int result, num, a;

        result = num = 0;
        do{
            System.out.println("Give a number:");
            a = scanner.nextInt();

            num++;
            result += a;
        }while(a != 0);        

        System.out.println("Number of numbers: " + (--num)) ;
        System.out.println("Sum of the numbers: " + result);               
    }
}