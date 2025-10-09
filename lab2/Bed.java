public class Bed extends Furniture {
    private double length;
    private double width;
    private boolean hasStorage;

    public Bed() {
        super();
        this.length = 0.0;
        this.width = 0.0;
        this.hasStorage = false;
    }


    public Bed(String material, String color, double price, double length, double width, boolean hasStorage) {
        super(material, color, price);
        this.length = length;
        this.width = width;
        this.hasStorage = hasStorage;
    }


    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public boolean isHasStorage() { return hasStorage; }
    public void setHasStorage(boolean hasStorage) { this.hasStorage = hasStorage; }


    @Override
    public void displayInfo() {
        System.out.println("Кровать:");
        System.out.println("Материал: " + getMaterial());
        System.out.println("Цвет: " + getColor());
        System.out.println("Цена: " + getPrice());
        System.out.println("Размеры: " + length + " x " + width + " см");
        System.out.println("Есть место для хранения: " + (hasStorage ? "да" : "нет"));
    }

    @Override
    public double calculateDiscount(double percent) {
        return getPrice() * (1 - percent / 100);
    }


    public double calculateSleepingArea() {
        return length * width;
    }
}
