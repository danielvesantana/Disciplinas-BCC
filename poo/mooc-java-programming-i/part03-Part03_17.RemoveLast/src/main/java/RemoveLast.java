import java.util.Scanner;
import java.util.ArrayList;

public class RemoveLast{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> strings = new ArrayList<>();

        strings.add("First");
        strings.add("Second");
        strings.add("Third");

        System.out.println(strings);

        removeLast(strings);
        removeLast(strings);

        System.out.println(strings);
    }

    public static void removeLast(ArrayList<String> strings){
        if(!strings.isEmpty()){
            strings.remove(strings.get(strings.size() - 1));
        }
    }
}