import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;

public class Nicknames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> names = new HashMap<>();

        String text;
        for(int i = 0; i < 3; i++){
            text = scanner.nextLine();

            String[] parts = text.split(" ");
            Pattern pattern = Pattern.compile("[A-Za-z]+");
            Matcher name = pattern.matcher(parts[0]);
            System.out.println("Name: " + name.group() + " and NickName: " + parts[3]);
        }
    }

}
