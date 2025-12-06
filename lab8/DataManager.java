import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
public class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();
    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }
    public void loadData(String sourceFile) {
        data.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void processData() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());
        List<Future<List<String>>> futures = new ArrayList<>();
        for (Object processor : processors) {
            futures.add(executor.submit(() -> {
                List<String> result = new ArrayList<>(data);
                Method[] methods = processor.getClass().getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(DataProcessor.class)) {
                        result = result.stream()
                                .map(s -> {
                                    try {
                                        return (String) method.invoke(processor, s);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                        return s;
                                    }
                                })
                                .filter(s -> !s.isEmpty())
                                .collect(Collectors.toList());
                    }
                }
                return result;
            }));
        }
        processedData.clear();
        for (Future<List<String>> f : futures) {
            processedData.addAll(f.get());
        }
        executor.shutdown();
    }
    public void saveData(String destinationFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {
            for (String line : processedData) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Данные успешно сохранены в " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
