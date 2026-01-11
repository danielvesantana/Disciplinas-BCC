import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class IndexOfSmallest{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList<>();

        int number;
        do{
            number = scanner.nextInt();

            if(number != 9999){
                lista.add(number);
            }
        }while(number != 9999);

        int valor = findSmallestNumber(lista);

        ArrayList<Integer> indexList = searchNumber(lista, valor);

        System.out.println("Smallest number: " + valor);

        for(int i = 0; i < indexList.size(); i++){
            System.out.println("Found at index: " + indexList.get(i));
        }

        scanner.close();
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
    
    public static int findSmallestNumber(ArrayList<Integer> lista){
        int smallestNumber = Integer.MAX_VALUE;

        for(int i = 0; i < lista.size(); i++){
            smallestNumber = Math.min(smallestNumber, lista.get(i));
        }

        return smallestNumber;
    }
}