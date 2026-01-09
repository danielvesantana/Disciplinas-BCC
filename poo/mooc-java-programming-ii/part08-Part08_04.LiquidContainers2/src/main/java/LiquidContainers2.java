
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();


        while (true) {
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            int amount = Integer.parseInt(parts[1]);

            switch(parts[0]){
                case "add":
                    first.add(amount);
                    break;
                case "move":
                    if (amount > 0) {
                        if(amount > first.contains()){
                            amount = first.contains(); 
                        }
                        first.remove(amount);
                        second.add(amount);
                        if(second.contains() > 100){
                            second.add(100);
                        }
                    }
                    break;
                case "remove":
                    second.remove(amount);
                    break;
            }
        }
    }

}
