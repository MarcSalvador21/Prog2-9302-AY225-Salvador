public class DataRecord {

    private String name;
    private double sales;

    public DataRecord(String name, double sales) {
        this.name = name;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public double getSales() {
        return sales;
    }
}