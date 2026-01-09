import java.util.Scanner;

public class SumOfASequence{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Last number?");
        int a = scanner.nextInt();

        int sum;

        sum = 0;
        for(int i = 1; i <= a; i++){
            sum += i;
        }

        System.out.println("The sum is " + sum);
    }
}