import java.util.Scanner;

public class AverageOfNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num, a;
        double result;
    
        result = num = 0;
        do{
            System.out.println("Give a number:");
            a = scanner.nextInt();

            if(a != 0){
                num++;
            }

            result += a;
        }while(a != 0);        

        result = result/num;
        System.out.println("Average of the numbers: " + (result)) ;
    }
}