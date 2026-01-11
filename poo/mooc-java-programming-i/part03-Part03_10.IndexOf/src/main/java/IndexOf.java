import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class IndexOf{
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

        System.out.println("Search for?");
        int valor = scanner.nextInt();

        ArrayList<Integer> indexList = searchNumber(lista, valor);

        for(int i = 0; i < indexList.size(); i++){
            System.out.println(valor + " is at index " + indexList.get(i));
        }
    }

    public static ArrayList<Integer> searchNumber(ArrayList<Integer> lista, int valor){
        ArrayList<Integer> indexList = new ArrayList<>();
        
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) == valor){
                indexList.add(i);
            }
        }

        return indexList;
    }
    
}