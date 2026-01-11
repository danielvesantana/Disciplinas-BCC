import java.util.Scanner;
import java.util.ArrayList;

public class NameOfTheOldest{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        makeList(lista, scanner);

        System.out.println("Name of the oldest: " + findOldest(lista));
    }

    public static void makeList(ArrayList<String> lista, Scanner scanner){
        String string;

        do{
            string = scanner.nextLine();

            if(!string.equals("")){
                lista.add(string);
            }
        }while(!string.equals(""));
    }

    public static String findOldest(ArrayList<String> lista){
        String[] partes;
        String oldest = "Não tem";
        int max;

        max = -1;
        for(int i = 0; i < lista.size(); i++){
            partes = lista.get(i).split(",");

            if(Integer.valueOf(partes[1]) > max){
                max = Integer.valueOf(partes[1]);
                oldest = partes[0];
            }
        }

        return oldest;
    }
}