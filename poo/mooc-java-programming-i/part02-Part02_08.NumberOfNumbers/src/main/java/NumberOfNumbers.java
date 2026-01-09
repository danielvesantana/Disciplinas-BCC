import java.util.Scanner;

public class NumberOfNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int nums, a;

        nums = 0;
        do{
            System.out.println("Give a number:");
            a = scanner.nextInt();

            nums++;
        }while(a != 0);        

        System.out.println("Number of numbers: " + (--nums));               
    }
}