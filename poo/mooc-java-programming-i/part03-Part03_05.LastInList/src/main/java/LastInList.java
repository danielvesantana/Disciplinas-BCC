import java.util.Scanner;
import java.util.ArrayList;

public class LastInList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> lista = new ArrayList<>();
        String nome;

        do{
            nome = scanner.nextLine();

            lista.add(nome);
        }while(!nome.equals(""));

        System.out.println(lista.get(lista.size() - 2));
    }
}