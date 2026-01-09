import java.nio.file.Files;
import java.nio.file.Paths;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                .map(line -> line.split(","))
                .sorted((p1, p2) -> p1[5].compareTo(p2[5]))
                .forEach(p -> System.out.println(p[3] + " (" + Integer.parseInt(p[4]) + "), " + p[2].split(" ")[1].trim() + ", " + Double.parseDouble(p[5])));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
