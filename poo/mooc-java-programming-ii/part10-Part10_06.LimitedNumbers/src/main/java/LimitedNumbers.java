
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while(true){
            int number = Integer.valueOf(scanner.nextLine());

            if(number < 0){
                break;
            }

            numbers.add(number);
        }

        List<Integer> nums = numbers.stream()
            .filter(num -> num >= 1 && num <= 5)
            .collect(Collectors.toCollection(ArrayList::new));

        nums.stream()
            .forEach(num -> System.out.println(num));
    }
}
