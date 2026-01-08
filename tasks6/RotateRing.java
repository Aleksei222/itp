import java.util.*;

public class RotateRing {

    public static String rotateRing(String s, int k) {
        int n = s.length();
        if (n == 0) return s;

        k = ((k % n) + n) % n;

        return s.substring(k) + s.substring(0, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(rotateRing(s, k));
    }
}
