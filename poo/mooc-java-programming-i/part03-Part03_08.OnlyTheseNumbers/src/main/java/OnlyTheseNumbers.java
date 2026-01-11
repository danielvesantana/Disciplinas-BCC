import java.util.Scanner;
import java.util.ArrayList;

public class OnlyTheseNumbers{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList<>();

        int number;
        do{
            number = scanner.nextInt();

            if(number != -1){
                lista.add(number);
            }
        }while(number != -1);

        System.out.println("From where? ");
        int begin = scanner.nextInt();

        System.out.println("To where?  ");
        int end = scanner.nextInt();

        for(int i = begin; i <= end; i++){
            System.out.println(lista.get(i));
        }
    }
}