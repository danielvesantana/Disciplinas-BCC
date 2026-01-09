
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Value of the gift?");
        double input = Double.valueOf(scan.nextLine());

        double tax;
        
        if(input < 5000){
            System.out.println("No tax!");
        }else{
            if(input >= 5000 && input <= 25000){
                tax = 100 + (input - 5000)*0.08;
            }else if(input >= 25000 && input <= 55000){
                tax = 1700 + (input - 25000)*0.1;
            }else if(input >= 55000 && input <= 200000){
                tax = 4700 + (input - 55000)*0.12;
            }else if(input >= 200000 && input <= 1000000){
                tax = 22100 + (input - 200000)*0.15;
            }else{
                tax = 142100 + (input - 1000000)*0.17;
            }
            System.out.println("Tax: " + tax);
        }


        scan.close();
    }
}
