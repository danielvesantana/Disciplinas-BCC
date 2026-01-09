import java.util.Scanner;

public class UserInterface {
    private TodoList instance;
    private Scanner scan;

    public UserInterface(TodoList instance, Scanner scan){
        this.instance = instance;
        this.scan = scan;
    }

    public void start(){
        String command;

        while(true){
            System.out.println("Command: ");
            command = scan.nextLine();

            switch(command){
                case "add":
                    System.out.println("To add: ");
                    String task = scan.nextLine();

                    instance.add(task);
                    break;
                case "list":
                    instance.print();
                    break;
                case "remove":
                    System.out.println("Which one is removed? ");
                    int index = Integer.parseInt(scan.nextLine());

                    instance.remove(index);
                    break;
                case "stop":
                    return;
            }
        }
    }
}
