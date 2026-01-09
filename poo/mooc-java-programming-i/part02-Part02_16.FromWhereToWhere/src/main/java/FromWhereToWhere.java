import java.util.Scanner;

public class FromWhereToWhere{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Where to?");
        int number1 = scanner.nextInt();

        System.out.println("Where from?");
        int number2 = scanner.nextInt();

        if(number1 >= number2){
            for(int i = number2; i <= number1; i++){
                System.out.println(i);
            }
        }
    }
}