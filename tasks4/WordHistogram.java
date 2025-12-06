import java.util.*;

public class WordHistogram {

    public static Map<String, Integer> wordHistogram(String text) {
        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
        String[] words = text.split("\\s+");
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Map<String, Integer> result = wordHistogram(line);

        System.out.print("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());
            if (i != result.size() - 1) System.out.print(", ");
            i++;
        }
        System.out.println("}");
    }
}
