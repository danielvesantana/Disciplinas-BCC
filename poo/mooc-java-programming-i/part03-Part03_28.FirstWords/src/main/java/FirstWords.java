import java.util.Scanner;
import java.util.ArrayList;

public class FirstWords{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        declaraString(scanner);
    }

    public static void declaraString(Scanner scanner){
        String string;

        do{
            string = scanner.nextLine();
            
            firstWords(string);
        }while(!string.equals(""));
    }

    public static void firstWords(String string){
        String[] piece = string.split(" ");

        System.out.println(piece[0]);
    }
}