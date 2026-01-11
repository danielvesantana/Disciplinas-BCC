import java.util.Scanner;
import java.util.ArrayList;

public class SecondPlusThird{
public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        int number;
        do{
            number = scanner.nextInt();

            list.add(number);
        }while(number != 0);

        System.out.println(list.get(1) + list.get(2));
    }
}