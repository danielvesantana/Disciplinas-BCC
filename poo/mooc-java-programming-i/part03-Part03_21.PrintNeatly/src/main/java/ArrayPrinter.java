import java.util.Scanner;
import java.util.ArrayList;

public class ArrayPrinter{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] array = {5, 1, 3, 4, 2};
        printNeatly(array);
    }

    public static void printNeatly(int[] array){
        System.out.print(array[0]);
        for(int i = 1; i < array.length; i++){
            System.out.print("," + array[i]);
        }

        System.out.println();
    }
}