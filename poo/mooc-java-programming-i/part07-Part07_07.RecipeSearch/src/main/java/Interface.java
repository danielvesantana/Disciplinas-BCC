import java.util.Scanner;

public class Interface {
    private Scanner scanner;
    private Recipe recipe;

    public Interface(Scanner scanner){
        this.scanner = scanner;
    }

    public void commands(Scanner scanner){
        System.out.println("Commands:\n" +
                           "list - lists the recipes \n" +
                           "stop - stops the program \n" +
                           "find name - searches recipes by name\n" +
                           "find cooking time - searches recipes by cooking time\n" +
                           "find ingredient - searches recipes by ingredient\n\n" + 
                           "Enter command:");
        String command = scanner.nextLine();

        switch(command){
            case "list":
                recipe.list(scanner);

                break;
            case "stop":
                return;
            case "find name":
                recipe.findName(scanner);

                break;
            case "find cooking time":
                recipe.findCookingTime(scanner);

                break;
            case "find ingredient":
                recipe.findIngredient(scanner);

                break;
        }
    }

}
