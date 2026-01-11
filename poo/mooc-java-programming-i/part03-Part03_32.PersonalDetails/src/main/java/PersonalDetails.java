import java.util.Scanner;
import java.util.ArrayList;

public class PersonalDetails{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        makeList(lista, scanner);
        findLongest(lista);
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

    public static void findLongest(ArrayList<String> lista){
        String[] partes;
        String longestName = " ";
        int sum, longest;

        sum = 0;
        longest = -1;
        for(int i = 0; i < lista.size(); i++){
            partes = lista.get(i).split(",");

            if(partes[0].length() > longestName.length()){
                longest = partes[0].length();
                longestName = partes[0];

            }
            sum += Integer.valueOf(partes[1]);
        }

        double average;
        average = (sum)/(double)(lista.size());
        System.out.println("Longest name: " + longestName + "\n" + "Average of the birth years: " +
        average);
    }
}