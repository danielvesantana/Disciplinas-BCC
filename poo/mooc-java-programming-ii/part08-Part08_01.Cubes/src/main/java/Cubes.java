
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while(!(input = scanner.nextLine()).equals("end")){
            int number = Integer.parseInt(input);
            System.out.println(number*number*number);
        }
    }
}
