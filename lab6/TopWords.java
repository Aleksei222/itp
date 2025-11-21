import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {

    public static void main(String[] args) {

        String filePath = "text.txt";

        File file = new File(filePath);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Map<String, Integer> wordCount = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zа-я0-9]", "");
            if (word.isEmpty()) continue;

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println("Top 10 words:");
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).getKey() + " - " + list.get(i).getValue());
        }
    }
}
