
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings = new ArrayList<String>();
        while(true){
            String str = scanner.nextLine();

            if(str.equals("")){
                break;
            }

            strings.add(str);
        }

        strings.stream()
            .forEach(str -> System.out.println(str));
    }
}
