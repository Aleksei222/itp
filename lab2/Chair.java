public class Chair extends Furniture {
    private boolean hasBack;
    private double height;
    private int legsCount;

    public Chair() {
        super();
        this.hasBack = true;
        this.height = 0.0;
        this.legsCount = 4;
    }


    public Chair(String material, String color, double price, boolean hasBack, double height, int legsCount) {
        super(material, color, price);
        this.hasBack = hasBack;
        this.height = height;
        this.legsCount = legsCount;
    }


    public boolean isHasBack() { return hasBack; }
    public void setHasBack(boolean hasBack) { this.hasBack = hasBack; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public int getLegsCount() { return legsCount; }
    public void setLegsCount(int legsCount) { this.legsCount = legsCount; }

    @Override
    public void displayInfo() {
        System.out.println("Стул:");
        System.out.println("Материал: " + getMaterial());
        System.out.println("Цвет: " + getColor());
        System.out.println("Цена: " + getPrice());
        System.out.println("Высота: " + height + " см");
        System.out.println("Количество ножек: " + legsCount);
        System.out.println("Со спинкой: " + (hasBack ? "да" : "нет"));
    }

    @Override
    public double calculateDiscount(double percent) {
        return getPrice() * (1 - percent / 100);
    }


    public void adjustHeight(double newHeight) {
        this.height = newHeight;
        System.out.println("Высота стула изменена на " + height + " см");
    }
}
