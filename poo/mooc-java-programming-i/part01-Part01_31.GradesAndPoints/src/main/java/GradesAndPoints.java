import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give points [0-100]:");
        int input = Integer.valueOf(scanner.nextLine());

        if(input < 0){
            System.out.println("impossible!");
        }else if(input <= 49){
            System.out.println("failed");
        }else if(input <= 59){
            System.out.println("1");
        }else if(input <= 69){
            System.out.println("2");
        }else if(input <= 79){
            System.out.println("3");
        }else if(input <= 89){
            System.out.println("4");
        }else if(input <= 100){
            System.out.println("5");
        }else{
            System.out.println("incredible!");
        }

        scanner.close();
    }
}
