import java.util.*;

public class Spread {

    public static double spread(int[] arr) {
        if (arr.length == 0) return 0;

        int min = arr[0];
        int max = arr[0];
        double sum = 0;

        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
            sum += x;
        }

        double avg = sum / arr.length;
        if (avg == 0) return 0;

        return (max - min) / avg;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\]\\s]", "");
        String[] parts = line.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        System.out.println(spread(arr));
    }
}
