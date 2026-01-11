import java.util.Scanner;
import java.util.ArrayList;

public class PrintInRange{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();

        adicionanumero(numbers, scanner);

        System.out.println("The numbers in the range [0, 5]");
        printNumbersInRange(numbers, 0, 5);

        System.out.println("The numbers in the range [3, 10]");
        printNumbersInRange(numbers, 3, 10);
    }

    public static void adicionanumero(ArrayList<Integer> numbers, Scanner scanner){
        Integer numero;
        do{
            numero = scanner.nextInt();

            if(!numero.equals(0)){
                numbers.add(numero);
            }
        }while(!numero.equals(0));
    }

    public static void printNumbersInRange(ArrayList<Integer> numbers, int lowerLimit, int upperLimit){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) >= lowerLimit && numbers.get(i) <= upperLimit){
                System.out.println(numbers.get(i));
            }
        }
    }
}