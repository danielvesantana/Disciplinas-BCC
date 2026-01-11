import java.util.Scanner;
import java.util.ArrayList;

public class OnTheList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> lista = new ArrayList<>();

        adicionaNome(lista, scanner);

        System.out.println("Search for?");
        String nome = scanner.nextLine();

        procuraNome(lista, nome);

    }

    public static void adicionaNome(ArrayList<String> lista, Scanner scanner){
        String nome;
        do{
            nome = scanner.nextLine();

            if(!nome.equals("")){
                lista.add(nome);
            }
        }while(!nome.equals(""));
    }

    public static void procuraNome(ArrayList<String> lista, String nome){
        if(lista.contains(nome)){
            System.out.println(nome + " was found!");
        }else{
            System.out.println(nome + " was not found!");
        }
    }
}