import java.util.Scanner;

public class Interface {    
    private Scanner scanner;
    private Database database;

    public Interface(Scanner scanner){
        this.scanner = scanner;
        this.database = new Database(); 
    }

    public void menu(){
        while(true){
            System.out.println("?");
            String operation = scanner.nextLine();

            String name, latinName;
            switch(operation){
                case "Add":
                    System.out.println("Name: ");
                    name = scanner.nextLine();
                    System.out.println("Name in Latin:");
                    latinName = scanner.nextLine();

                    Bird bird = new Bird(name, latinName);
                    database.Add(bird);
                    break;
                case "Observation":
                    System.out.println("Bird? ");
                    name = scanner.nextLine();

                    database.addObservation(name);
                    break;
                case "All":
                    database.printBirds();

                    break;
                case "One":
                    System.out.println("Bird?");
                    name = scanner.nextLine();

                    database.printBird(name);
                    break;
                case "Quit":
                    return;
            }
        }
    }
}
