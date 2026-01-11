import java.util.Scanner;
import java.util.ArrayList;

public class AVClub{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        lerString(lista, scanner);
        imprimeString(lista);
    }

    public static void lerString(ArrayList<String> lista, Scanner scanner){
        String str;

        do{
            str = scanner.nextLine();

            if(str != null && !str.isEmpty()){
                lista.add(str);
            }
        }while(!str.equals(""));
    }

    public static void imprimeString(ArrayList<String> lista){
        for(int i = 0; i < lista.size(); i++){
            String[] pieces = lista.get(i).split(" "); 

            for(int j = 0; j < pieces.length; j++){
                if(pieces[j].contains("av")){
                    System.out.println(pieces[j]);
                }
            }
        }
    }
}