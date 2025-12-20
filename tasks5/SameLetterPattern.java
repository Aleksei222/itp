import java.util.*;

public class SameLetterPattern {

    public static boolean sameLetterPattern(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Character> mapAtoB = new HashMap<>();
        Map<Character, Character> mapBtoA = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);

            if (mapAtoB.containsKey(ca)) {
                if (mapAtoB.get(ca) != cb) return false;
            } else {
                mapAtoB.put(ca, cb);
            }

            if (mapBtoA.containsKey(cb)) {
                if (mapBtoA.get(cb) != ca) return false;
            } else {
                mapBtoA.put(cb, ca);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(",");
        String a = parts[0].trim();
        String b = parts[1].trim();

        System.out.println(sameLetterPattern(a, b));
    }
}
