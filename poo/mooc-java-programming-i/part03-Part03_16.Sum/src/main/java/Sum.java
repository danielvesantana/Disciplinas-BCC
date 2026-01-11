import java.util.Scanner;
import java.util.ArrayList;

public class Sum{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(2);
        numbers.add(6);
        numbers.add(-1);
        System.out.println(sum(numbers));

        numbers.add(5);
        numbers.add(1);
        System.out.println(sum(numbers));
    }

    public static int sum(ArrayList<Integer> numbers){
        int sum;

        sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }

        return sum;
    }
}