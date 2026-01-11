import java.util.Scanner;
import java.util.ArrayList;

public class GreatestInList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList<>();
        int number, max;

        max = -1;
        do{
            number = scanner.nextInt();

            max = Math.max(max, number);
            if(number != -1){
                lista.add(number);
            }
        }while(number != -1);

        System.out.println(max);
    }
}