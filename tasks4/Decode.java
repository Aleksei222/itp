import java.util.*;

public class Decode {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        String[] parts = line.split("\\s*,\\s*");
        if (parts.length != 2) {
            System.out.println("[]");
            return;
        }

        String message = parts[0].trim();
        String key = parts[1].trim();

        if (message.startsWith("\"") && message.endsWith("\""))
            message = message.substring(1, message.length() - 1);
        if (key.startsWith("\"") && key.endsWith("\""))
            key = key.substring(1, key.length() - 1);

        int n = Math.min(message.length(), key.length());
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = message.charAt(i) ^ key.charAt(i);
        }

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
