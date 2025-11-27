import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DataManager manager = new DataManager();

        // Регистрируем обработчики
        manager.registerDataProcessor(new UpperCaseProcessor());
        manager.registerDataProcessor(new AddPrefixProcessor());
        manager.registerDataProcessor(new FilterProcessor());

        // Загружаем данные
        manager.loadData("input.txt");

        // Обрабатываем данные
        manager.processData();

        // Сохраняем результаты
        manager.saveData("output.txt");
    }
}
