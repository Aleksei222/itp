import java.util.*;

public class DigitHistogram {

    public static int[] digitHistogram(long num) {
        int[] count = new int[10];
        while (num > 0) {
            int digit = (int)(num % 10);
            count[digit]++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        int[] output = digitHistogram(n);

        System.out.print("[");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if (i != output.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
