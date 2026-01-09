import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recipe {
    private ArrayList<ArrayList<String>> recipes;
    
    public void list(Scanner scanner){
        System.out.println("Recipes: ");
        while(scanner.hasNextLine()){
            System.out.println(scanner);
        }
    }

    public void findIngredient(Scanner scanner){
        System.out.println("Ingredient: ");
        String regex = scanner.nextLine();

        findRecipe(regex, scanner);
    }
    
    public void findName(Scanner scanner){
        System.out.println("Searched word: ");
        String regex = scanner.nextLine();

        findRecipe(regex, scanner);
    }

    public void findCookingTime(Scanner scanner){
        System.out.println("Max cooking time: ");
        String regex = scanner.nextLine();

        findRecipe(regex, scanner);
    }

    
}
