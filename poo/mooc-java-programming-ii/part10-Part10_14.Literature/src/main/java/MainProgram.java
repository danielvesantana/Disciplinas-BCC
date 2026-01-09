
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while(true){
            System.out.println("Input the name of the book, empty stops:");
            String bookName = scanner.nextLine();
            if(bookName.equals("")){
                break;
            }
            System.out.println("Input the age recommendation:");
            int age = Integer.parseInt(scanner.nextLine());
            
            books.add(new Book(bookName, age));
        }

        System.out.println(books.size() + " books in total.");
        System.out.println("Books:");

        books.stream()
            .sorted((b1, b2) -> b1.compareTo(b2))
            .forEach(book -> System.out.println(book.getName() + " (recommended for " + 
            book.getAge() + " year-olds or older)"));
    }
}