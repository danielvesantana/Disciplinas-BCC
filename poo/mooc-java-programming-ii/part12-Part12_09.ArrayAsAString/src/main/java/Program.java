
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array){
        String impression = "";

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                impression += array[i][j];
            }
            impression += "\n";
        }

        return impression;
    }
}
