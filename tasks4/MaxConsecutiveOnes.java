import java.util.*;

public class MaxConsecutiveOnes {

    public static int maxConsecutiveOnes(int[] arr) {
        int maxCount = 0;
        int count = 0;
        for (int num : arr) {
            if (num == 1) {
                count++;
                if (count > maxCount) maxCount = count;
            } else {
                count = 0;
            }
        }
        return maxCount;
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

        System.out.println(maxConsecutiveOnes(arr));
    }
}
