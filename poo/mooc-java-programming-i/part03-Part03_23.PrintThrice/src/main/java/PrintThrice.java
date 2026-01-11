import java.util.Scanner;
import java.util.ArrayList;

public class PrintThrice{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a word: ");
        String word = scanner.nextLine();

        String output = word + word + word;
        System.out.println(output);
    }
}