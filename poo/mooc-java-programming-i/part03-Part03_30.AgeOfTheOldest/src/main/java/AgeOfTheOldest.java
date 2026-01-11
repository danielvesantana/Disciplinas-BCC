import java.util.Scanner;
import java.util.ArrayList;

public class AgeOfTheOldest{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        makeList(lista, scanner);
        int ans = findOldest(lista);

        System.out.println("Age of the oldest: " + ans);
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

    public static int findOldest(ArrayList<String> lista){
        String[] pieces;
        int max;

        max = -1;
        for(int i = 0; i < lista.size(); i++){
            pieces = lista.get(i).split(",");

            max = Math.max(max, Integer.valueOf(pieces[1])); 
        }

        return max;
    }
}