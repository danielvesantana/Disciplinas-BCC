import java.util.Scanner;

public class Interface {
    private Scanner scanner;
    private GradeStatistics grade;
    private String output;

    public Interface(Scanner scanner, GradeStatistics grade){
        this.scanner = scanner;
        this.grade = grade; 
    }

    public void menu(){
        read();

        print(grade.pointAverages());
        print(grade.passingGrade());
        print(grade.passPercentage());
        print(grade.gradeDistribution());
    }

    public void read(){
        System.out.println("Enter point totals, -1 stops:");

        while (true) { 
            int number = Integer.parseInt(scanner.nextLine());

            if(number == -1){
                break;
            }

            grade.add(number);
        }
    }

    public void print(String output){
        System.out.println(output);
    }
}
