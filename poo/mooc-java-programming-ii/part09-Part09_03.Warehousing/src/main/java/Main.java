public class Main {

    public static void main(String[] args) {
        ProductWarehouseWithHistory pwh = new ProductWarehouseWithHistory("beer", 10, 2);
        pwh.takeFromWarehouse(1);
        //System.out.println(juice.history()); // [1000.0, 988.7, 989.7]

        pwh.printAnalysis();
    }

}
