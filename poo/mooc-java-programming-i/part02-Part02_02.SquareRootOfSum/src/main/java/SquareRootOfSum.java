import java.util.Scanner;

public class SquareRootOfSum{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        double resultado = a+b;
        resultado = Math.sqrt(resultado);

        System.out.println((int)resultado);
    }
}