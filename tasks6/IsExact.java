import java.util.*;

public class IsExact {

    public static int[] isExact(int n) {
        return helper(n, 1, 1);
    }

    private static int[] helper(int original, int current, int k) {
        if (current == original) {
            return new int[]{original, k};
        }
        if (current > original) {
            return new int[0];
        }
        return helper(original, current * (k + 1), k + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] res = isExact(n);

        if (res.length == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }
}
