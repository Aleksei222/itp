public class Table extends Furniture {
    private String shape;
    private double length;
    private double width;
    private static int tableCount = 0; 

    public Table() {
        super();
        this.shape = "прямоугольный";
        this.length = 0.0;
        this.width = 0.0;
        tableCount++;
    }


    public Table(String material, String color, double price, String shape, double length, double width) {
        super(material, color, price);
        this.shape = shape;
        this.length = length;
        this.width = width;
        tableCount++;
    }


    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }

    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }

    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public static int getTableCount() { return tableCount; }


    @Override
    public void displayInfo() {
        System.out.println("Стол:");
        System.out.println("Материал: " + getMaterial());
        System.out.println("Цвет: " + getColor());
        System.out.println("Цена: " + getPrice());
        System.out.println("Форма: " + shape);
        System.out.println("Размеры: " + length + " x " + width + " см");
    }

    @Override
    public double calculateDiscount(double percent) {
        return getPrice() * (1 - percent / 100);
    }


    public double calculateArea() {
        return length * width;
    }
}
