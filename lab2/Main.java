public class Main {
    public static void main(String[] args) {
        
        Chair chair = new Chair("Дерево", "Коричневый", 2500, true, 45, 4);
        Table table = new Table("Металл", "Черный", 8000, "круглый", 120, 120);
        Bed bed = new Bed("Дерево", "Белый", 15000, 200, 160, true);

        OfficeChair officeChair = new OfficeChair("Пластик", "Серый", 5500, true, 50, 5, true, true);
        WritingTable writingTable = new WritingTable("Дерево", "Светлый дуб", 10000, "прямоугольный", 140, 70, 3, true);
        DiningTable diningTable = new DiningTable("Стекло", "Белый", 12000, "овальный", 160, 90, 6, true);

        System.out.println("- Информация о мебели -");
        chair.displayInfo();
        System.out.println();
        table.displayInfo();
        System.out.println();
        bed.displayInfo();
        System.out.println();
        officeChair.displayInfo();
        System.out.println();
        writingTable.displayInfo();
        System.out.println();
        diningTable.displayInfo();

        System.out.println("\n- Проверка функционала -");
        officeChair.move();
        writingTable.openDrawer();
        diningTable.extendTable();

        System.out.println("\nКоличество созданных столов: " + Table.getTableCount());
    }
}
