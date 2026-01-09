
import java.util.Arrays;


public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {4, 7, 8, 6, 9, 2, 3};

        sort(array);
    }

    public static int indexOfSmallest(int[] array){
        int min, index;

        index = 0;
        min = smallest(array);

        for(int i = 0; i < array.length; ++i){
            if(array[i] == min){
                index = i;
                break;
            }
        }

        return index;
    }

    public static int smallest(int[] array){
        int min = array[0];

        for(int x : array){
            if(x < min){
                min = x;
            }
        }

        return min;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex){
        int min = table[startIndex];
        int index = startIndex;

        for(int i = startIndex; i < table.length; ++i){
            if(min >= table[i]){
                min = table[i];
                index = i;
            }
        }

        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int aux;

        aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

    public static void sort(int[] array) {
        int index;

        for(int i = 0; i < array.length; ++i){
            index = indexOfSmallestFrom(array, i);

            swap(array, i, index);

            System.out.println(Arrays.toString(array));
        }
    }
}