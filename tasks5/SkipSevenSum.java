import java.util.*;

public class SkipSevenSum {

    public static int skipSevenSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            boolean hasSeven = false;
            while (x > 0) {
                if (x % 10 == 7) {
                    hasSeven = true;
                    break;
                }
                x /= 10;
            }
            if (!hasSeven) sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(skipSevenSum(n));
    }
}
