import java.util.Scanner;
import java.util.ArrayList;

public class AverageOfAList{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> lista = new ArrayList<>();

        declaraLista(lista, scanner);
        System.out.println(calculaMedia(somaValoresLista(lista), lista.size()));
    }

    public static void declaraLista(ArrayList<Integer> lista, Scanner scanner){
        int numero;

        do{
            numero = scanner.nextInt();

            if(numero != -1){
                lista.add(numero);
            }
        }while(numero != -1);
    }

    public static int somaValoresLista(ArrayList<Integer> lista){
        int soma;

        soma = 0;
        for(int i = 0; i < lista.size(); i++){
            soma += lista.get(i);
        }

        return soma;
    }

    public static double calculaMedia(int soma, int quantidade_de_elementos){
        return (soma)/(double)(quantidade_de_elementos);
    }
}