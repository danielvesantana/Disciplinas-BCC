import java.util.Scanner;
import java.util.ArrayList;

public class ListSize{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<String> listaNome = new ArrayList<>();
		
		String nome;
		int size = 0;
		do{
			nome = scanner.nextLine();
			
			size++;
			listaNome.add(nome);
		}while(!nome.equals(""));
		size--;

		System.out.println(size);
	}
}
