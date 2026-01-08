import java.util.*;

public class IsValid {

    public static String isValid(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        Map<Integer, Integer> countFreq = new HashMap<>();
        for (int f : freq.values()) countFreq.put(f, countFreq.getOrDefault(f, 0) + 1);

        if (countFreq.size() == 1) return "YES";
        if (countFreq.size() == 2) {
            List<Integer> keys = new ArrayList<>(countFreq.keySet());
            int f1 = keys.get(0), f2 = keys.get(1);
            int c1 = countFreq.get(f1), c2 = countFreq.get(f2);

            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return "YES";
            if ((Math.abs(f1 - f2) == 1) && ((c1 == 1) || (c2 == 1))) return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        System.out.println(isValid(input));
    }
}
