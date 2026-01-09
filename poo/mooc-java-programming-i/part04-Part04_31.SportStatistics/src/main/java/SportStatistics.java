import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> games = new ArrayList<>();

        System.out.println("File: ");
        String fileName = scan.nextLine();

        System.out.println("Team: ");
        String gameName = scan.nextLine();

        int count, wins, losses;
        wins = losses = count = 0;
        try(Scanner scanner = new Scanner(Paths.get(fileName))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                
                String[] aux = line.split(",");
                
                if(aux[0].equals(gameName) || aux[1].equals(gameName)){
                    count++;

                    if(aux[0].equals(gameName)){
                        if(Integer.valueOf(aux[2]) > Integer.valueOf(aux[3])){
                            wins++;
                        }else{
                            losses++;
                        }
                    }else if(aux[1].equals(gameName)){
                        if(Integer.valueOf(aux[3]) > Integer.valueOf(aux[2])){
                            wins++;
                        }else{
                            losses++;
                        }
                    }

                }                
            }
        }catch(Exception e){
            System.out.println("Arquivo não encontrado " + e.getMessage());
        }
        System.out.println("Games: " + count);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }

}
