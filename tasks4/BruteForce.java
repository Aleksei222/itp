import java.util.*;

public class BruteForce {

    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        if (n > k) return result;

        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < k; i++) alphabet.add((char) ('0' + i));

        permute(alphabet, 0, n, result);
        return result;
    }

    private static void permute(List<Character> arr, int start, int n, List<String> result) {
        if (start == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append(arr.get(i));
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            Collections.swap(arr, i, start);
            permute(arr, start + 1, n, result);
            Collections.swap(arr, i, start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(",");
        int n = Integer.parseInt(parts[0].trim());
        int k = Integer.parseInt(parts[1].trim());
        List<String> output = bruteForce(n, k);

        System.out.print("[");
        for (int i = 0; i < output.size(); i++) {
            System.out.print("\"" + output.get(i) + "\"");
            if (i != output.size() - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
