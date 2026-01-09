
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int first, second;

        first = second = 0;
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" "); 

            input = parts[0];
            int liquid = Integer.parseInt(parts[1]);

            if(liquid < 0){
                continue;
            }

            switch(input){
                case "add":
                    if(first + liquid >= 100){
                        first = 100;
                    }else{
                        first += liquid;
                    }

                    break;
                case "move":
                    if(first - liquid <= 0){
                        liquid = first;
                        first = 0;
                    }else{
                        first -= liquid;
                    }

                    if(second + liquid >= 100){
                        second = 100;
                    }else{
                        second += liquid;
                    }

                    break;
                case "remove":
                    if(second - liquid <= 0){
                        second = 0;
                    }else{
                        second -= liquid;
                    }
                    break;
            }
        }
    }

}
