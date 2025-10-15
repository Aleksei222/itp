import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> table = new HashTable<>();

        table.put("apple", 10);
        table.put("banana", 20);
        table.put("orange", 30);

        System.out.println("apple = " + table.get("apple")); 
        System.out.println("size = " + table.size());       

        table.put("apple", 15); 
        System.out.println("apple = " + table.get("apple"));

        table.remove("banana");
        System.out.println("size = " + table.size()); 
        System.out.println("isEmpty = " + table.isEmpty());


        HashMap<String, Product> storage = new HashMap<>();

        storage.put("4601234567897", new Product("Coffee", 249.9, 5));
        storage.put("4819876543210", new Product("shampoo", 50.24 , 3));

        System.out.println("Barcode 4601234567897:\n" + storage.get("4601234567897").getInfo());
        System.out.println("Barcode 4819876543210:\n" + storage.get("4819876543210").getInfo());

        storage.remove("4819876543210");
        System.out.println("Barcode 4819876543210:\n" + storage.get("4819876543210"));
    }
}
