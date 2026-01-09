public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, 
    double initialBalance){
        super(productName, capacity);
        super.addToWarehouse(initialBalance);

        this.history = new ChangeHistory();
        this.history.add(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        double balance = super.getBalance();
        this.history.add(balance);
    }

    @Override
    public double takeFromWarehouse(double amount){
        double quantity = super.takeFromWarehouse(amount);
        double balance = super.getBalance();
        this.history.add(balance);

        return quantity;
    }

    public void printAnalysis(){
        System.out.println("Product: " + super.getName() + "\n" +
                           "History: " + this.history.toString() + "\n" +
                           "Largest amount of product: " + this.history.maxValue() + "\n" +
                           "Smallest amount of product: " + this.history.minValue() + "\n" +
                           "Average: " + this.history.average());
    }

    public String history(){
        return this.history.toString();
    }
}