import java.util.Scanner;

public class BooleanInput{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Write something: ");
        boolean flag = Boolean.valueOf(scanner.nextLine());

        System.out.println("True or false? " + flag); //O método Boolean.valueOf(String) retorna true 
                                                      //apenas se a string passada for exatamente "true"
        scanner.close();
    }
}