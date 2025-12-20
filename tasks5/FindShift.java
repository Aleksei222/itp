import java.util.*;

public class FindShift {

    public static int findShift(String a, String b) {
        if (a.length() != b.length()) return -1;

        int shift = (b.charAt(0) - a.charAt(0) + 26) % 26;

        for (int i = 0; i < a.length(); i++) {
            int curr = (b.charAt(i) - a.charAt(i) + 26) % 26;
            if (curr != shift) return -1;
        }

        return shift;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(",");
        String a = parts[0].trim();
        String b = parts[1].trim();

        System.out.println(findShift(a, b));
    }
}
