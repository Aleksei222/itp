import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DataManager manager = new DataManager();

        manager.registerDataProcessor(new UpperCaseProcessor());
        manager.registerDataProcessor(new AddPrefixProcessor());
        manager.registerDataProcessor(new FilterProcessor());

        manager.loadData("input.txt");

        manager.processData();

        manager.saveData("output.txt");
    }
}
