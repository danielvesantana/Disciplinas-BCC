import java.util.Scanner;

public class OnlyPositives{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("Give a number: ");

            int a = scanner.nextInt();

            if(a > 0){
                a = a * a;
                System.out.println(a);
            }else if(a < 0){
                System.out.println("Unsuitable number");
            }else{
                break;
            }
        }
    }
}