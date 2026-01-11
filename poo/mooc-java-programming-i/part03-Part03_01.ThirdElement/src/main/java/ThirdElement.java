import java.util.Scanner;
import java.util.ArrayList;

public class ThirdElement{
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

           ArrayList<String> listaNomes = new ArrayList<>();
           String nome;

           do{
               nome = scanner.nextLine();

               listaNomes.add(nome);
           }while(!nome.equals(""));

           System.out.println(listaNomes.get(2));
       }
}