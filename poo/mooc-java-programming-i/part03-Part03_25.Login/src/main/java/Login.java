import java.util.Scanner;
import java.util.ArrayList;

public class Login{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] usernames = {"alex", "emma"};
        String[] passwords = {"sunshine", "haskell"};

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println(verificaUsuario(username, password, usernames, passwords));
    }

    public static String verificaUsuario(String username, String password, String[] usernames, String[] passwords){
        for(int i = 0; i < usernames.length; i++){
            if(username.equals(usernames[i]) && password.equals(passwords[i])){
                return "You have successfully logged in!";
            }
        }

        return "Incorrect username or password!";
    }
}