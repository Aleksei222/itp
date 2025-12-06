import java.util.*;

public class EvaluateGrades {

    public static Map<String, Integer> evaluateGrades(int[] grades) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("A", 0);
        result.put("B", 0);
        result.put("C", 0);
        result.put("D", 0);
        result.put("F", 0);

        for (int g : grades) {
            if (g >= 90 && g <= 100) result.put("A", result.get("A") + 1);
            else if (g >= 80) result.put("B", result.get("B") + 1);
            else if (g >= 70) result.put("C", result.get("C") + 1);
            else if (g >= 60) result.put("D", result.get("D") + 1);
            else result.put("F", result.get("F") + 1);
        }

        // Удаляем категории с нулевым значением
        result.entrySet().removeIf(entry -> entry.getValue() == 0);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        line = line.replaceAll("[\\[\\]\\s]", "");
        String[] parts = line.split(",");
        int[] grades = new int[parts.length];
        for (int i = 0; i < parts.length; i++) grades[i] = Integer.parseInt(parts[i]);

        Map<String, Integer> output = evaluateGrades(grades);

        System.out.print("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : output.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());
            if (i != output.size() - 1) System.out.print(", ");
            i++;
        }
        System.out.println("}");
    }
}
