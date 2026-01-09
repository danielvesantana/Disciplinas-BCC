import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TodoList instance = new TodoList();
        UserInterface user = new UserInterface(instance, scan);

        user.start();
    }
}
