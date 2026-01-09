
import java.nio.file.Paths;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("File to read: ");
        String fileName = scanner.nextLine();

        Interface Interface = new Interface(scanner);
        try(Scanner scan = new Scanner(Paths.get(fileName))){
            Interface.commands(scan);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
