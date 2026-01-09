import java.util.Scanner;

public class AverageOfPositiveNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num, a;
        double result;
    
        result = num = 0;
        do{
            a = scanner.nextInt();

            if(a > 0){
                num++;
                result += a;
            }
        }while(a != 0);        


        result = result/num;
        if(num != 0){
            System.out.println(result);
        }else{
            System.out.println("Cannot calculate the average");
        }
    }
}