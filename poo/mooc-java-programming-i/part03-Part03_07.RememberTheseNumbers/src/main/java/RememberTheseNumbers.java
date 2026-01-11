import java.util.Scanner;
import java.util.ArrayList;

public class RememberTheseNumbers{
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

        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
}