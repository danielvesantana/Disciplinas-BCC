public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int ans = Math.max(number1, number2);
        ans = Math.max(ans, number3);

        return ans;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}
