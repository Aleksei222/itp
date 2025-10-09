public class WritingTable extends Table {
    private int drawersCount;  
    private boolean hasKeyboardTray; 

    public WritingTable() {
        super();
        this.drawersCount = 0;
        this.hasKeyboardTray = false;
    }

    public WritingTable(String material, String color, double price,
                        String shape, double length, double width,
                        int drawersCount, boolean hasKeyboardTray) {
        super(material, color, price, shape, length, width);
        this.drawersCount = drawersCount;
        this.hasKeyboardTray = hasKeyboardTray;
    }

    public int getDrawersCount() { return drawersCount; }
    public void setDrawersCount(int drawersCount) { this.drawersCount = drawersCount; }

    public boolean isHasKeyboardTray() { return hasKeyboardTray; }
    public void setHasKeyboardTray(boolean hasKeyboardTray) { this.hasKeyboardTray = hasKeyboardTray; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество ящиков: " + drawersCount);
        System.out.println("Полка под клавиатуру: " + (hasKeyboardTray ? "да" : "нет"));
    }

    public void openDrawer() {
        System.out.println("Вы открыли ящик письменного стола.");
    }
}
