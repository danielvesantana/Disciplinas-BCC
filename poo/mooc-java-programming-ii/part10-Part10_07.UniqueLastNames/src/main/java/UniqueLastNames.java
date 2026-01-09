import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UniqueLastNames {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Continue personal information input? \"quit\" ends:");
            String continueQ = "quit";
            if(scanner.hasNextLine()){continueQ = scanner.nextLine();}

            if (continueQ.equals("quit")) {
                break;
            }

            System.out.print("Input first name: ");
            String firstName = "NaN";
            if(scanner.hasNextLine()){firstName = scanner.nextLine();}
            System.out.print("Input last name: ");
            String lastName = "NaN";
            if(scanner.hasNextLine()){lastName = scanner.nextLine();}
            System.out.print("Input the year of birth: ");
            int birthYear = 0;
            if(scanner.hasNextLine()){birthYear = Integer.valueOf(scanner.nextLine());}

            persons.add(new Person(firstName, lastName, birthYear));
            System.out.println("");
        }

        System.out.println("Unique last names in alphabetical order:");
        // Implement the printing of the unique last names in alphabetical order here:
        ArrayList<String> lastName = persons.stream()
                                .map(name -> name.getLastName())
                                .distinct()
                                .collect(Collectors.toCollection(() -> new ArrayList<String>()));

        Collections.sort(lastName);

        lastName.stream()
            .forEach(name -> System.out.println(name));
    } 
}
