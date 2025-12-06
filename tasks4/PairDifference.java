import java.util.*;

public class PairDifference {

    public static int pairDifference(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }
        return count / 2; // делим на 2, так как каждая пара считается дважды
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split("\\],");
        String arrayPart = parts[0].replaceAll("[\\[\\]\\s]", "");
        String kPart = parts[1].trim();

        String[] nums = arrayPart.split(",");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i]);
        int k = Integer.parseInt(kPart);

        System.out.println(pairDifference(arr, k));
    }
}
