
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Give a year:");
        int input = Integer.valueOf(scan.nextLine());

        if(input % 100 == 0){
            if(input % 400 == 0){
                System.out.println("The year is a leap year.");
            }else{
                System.out.println("The year is not a leap year.");
            }
        }else if(input % 4 == 0){
            System.out.println("The year is a leap year.");
        }else{
            System.out.println("The year is not a leap year.");
        }

        scan.close();
    }
}
