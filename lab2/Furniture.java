public abstract class Furniture {
    private String material;
    private String color;
    private double price;

    public Furniture() {
        this.material = "не указан";
        this.color = "не указан";
        this.price = 0.0;
    }

    public Furniture(String material, String color, double price) {
        this.material = material;
        this.color = color;
        this.price = price;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public abstract void displayInfo();
    public abstract double calculateDiscount(double percent);
}
