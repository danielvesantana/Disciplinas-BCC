import java.util.Scanner;

public class SumOfASequenceTheSequel{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("First number?");
        int a = scanner.nextInt();

        System.out.println("Last number?");
        int b = scanner.nextInt();

        int sum;

        sum = 0;
        for(int i = a; i <= b; i++){
            sum += i;
        }

        System.out.println("The sum is " + sum);
    }
}