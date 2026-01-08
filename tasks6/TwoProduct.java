import java.util.*;

public class TwoProduct {

    public static int[] twoProduct(int[] arr, int n) {
        Set<Integer> seen = new HashSet<>();

        for (int x : arr) {
            if (x != 0 && n % x == 0 && seen.contains(n / x)) {
                return new int[]{n / x, x};
            }
            seen.add(x);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        int split = line.lastIndexOf(']');
        String arrPart = line.substring(0, split + 1);
        String nPart = line.substring(split + 1).replace(",", "").trim();

        int n = Integer.parseInt(nPart);

        arrPart = arrPart.replaceAll("[\\[\\]]", "");
        String[] nums = arrPart.split(",");
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i].trim());
        }

        int[] res = twoProduct(arr, n);

        if (res.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }
}
