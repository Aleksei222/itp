public class DiningTable extends Table {
    private int seats;
    private boolean extendable;

    public DiningTable() {
        super();
        this.seats = 4;
        this.extendable = false;
    }

    public DiningTable(String material, String color, double price,
                       String shape, double length, double width,
                       int seats, boolean extendable) {
        super(material, color, price, shape, length, width);
        this.seats = seats;
        this.extendable = extendable;
    }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public boolean isExtendable() { return extendable; }
    public void setExtendable(boolean extendable) { this.extendable = extendable; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество мест: " + seats);
        System.out.println("Раскладной: " + (extendable ? "да" : "нет"));
    }

    public void extendTable() {
        if (extendable) {
            System.out.println("Обеденный стол разложен - теперь за ним поместится больше гостей!");
        } else {
            System.out.println("Этот стол не раскладывается.");
        }
    }
}
