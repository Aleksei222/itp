import java.util.Map;
import java.util.TreeMap;

public class SalesTracker {
    private TreeMap<String, Integer> sales = new TreeMap<>();
    public void addSale(String product, int quantity) {
        sales.put(product, sales.getOrDefault(product, 0) + quantity);
    }
    public void printSales() {
        System.out.println("Список продаж:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + " — " + entry.getValue());
        }
    }
    public int totalSales() {
        int sum = 0;
        for (int qty : sales.values()) {
            sum += qty;
        }
        return sum;
    }
    public String mostPopular() {
        String top = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                top = entry.getKey();
            }
        }
        return top;
    }
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Apple", 5);
        tracker.addSale("Banana", 3);
        tracker.addSale("Apple", 2);
        tracker.addSale("Milk", 4);
        tracker.printSales();
        System.out.println("Общее количество проданных товаров: " + tracker.totalSales());
        System.out.println("Самый популярный товар: " + tracker.mostPopular());
    }
}
