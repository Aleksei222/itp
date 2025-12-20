import java.util.*;

public class IsLandscape {

    public static boolean isLandscape(int[] arr) {
        if (arr.length < 3) return false;

        int i = 1;
        while (i < arr.length && arr[i] > arr[i - 1]) i++;

        if (i == 1 || i == arr.length) return false;

        while (i < arr.length && arr[i] < arr[i - 1]) i++;

        return i == arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        line = line.replaceAll("[\\[\\]\\s]", "");
        String[] parts = line.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(isLandscape(arr));
    }
}
