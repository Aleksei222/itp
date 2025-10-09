public class OfficeChair extends Chair {
    private boolean hasWheels;
    private boolean adjustableBack;

    public OfficeChair() {
        super();
        this.hasWheels = true;
        this.adjustableBack = true;
    }

    public OfficeChair(String material, String color, double price,
                       boolean hasBack, double height, int legsCount,
                       boolean hasWheels, boolean adjustableBack) {
        super(material, color, price, hasBack, height, legsCount);
        this.hasWheels = hasWheels;
        this.adjustableBack = adjustableBack;
    }

    public boolean isHasWheels() { return hasWheels; }
    public void setHasWheels(boolean hasWheels) { this.hasWheels = hasWheels; }

    public boolean isAdjustableBack() { return adjustableBack; }
    public void setAdjustableBack(boolean adjustableBack) { this.adjustableBack = adjustableBack; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Колёсики: " + (hasWheels ? "есть" : "нет"));
        System.out.println("Регулируемая спинка: " + (adjustableBack ? "да" : "нет"));
    }

    public void move() {
        if (hasWheels)
            System.out.println("Стул катится по офису!");
        else
            System.out.println("Этот стул неподвижен.");
    }
}
