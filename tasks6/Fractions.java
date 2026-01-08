import java.math.*;
import java.util.*;

public class Fractions {

    public static String fractions(String s) {
        String integerPart = "0";
        String nonRepeat = "";
        String repeat = "";

        if (s.contains(".")) {
            String[] parts = s.split("\\.");
            integerPart = parts[0];
            String frac = parts[1];
            if (frac.contains("(")) {
                int idx = frac.indexOf('(');
                nonRepeat = frac.substring(0, idx);
                repeat = frac.substring(idx + 1, frac.length() - 1);
            } else {
                nonRepeat = frac;
            }
        } else {
            integerPart = s;
        }

        int k = nonRepeat.length();
        int r = repeat.length();

        BigInteger powK = BigInteger.TEN.pow(k);
        BigInteger powR = BigInteger.TEN.pow(r);

        BigInteger numerator;
        BigInteger denominator;

        if (r > 0) {
            BigInteger part1 = new BigInteger(integerPart + nonRepeat + repeat);
            BigInteger part2 = new BigInteger(integerPart + nonRepeat);
            numerator = part1.subtract(part2);
            denominator = powK.multiply(powR.subtract(BigInteger.ONE));
        } else {
            numerator = new BigInteger(integerPart + nonRepeat);
            denominator = powK;
        }

        BigInteger g = numerator.gcd(denominator);
        numerator = numerator.divide(g);
        denominator = denominator.divide(g);

        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        System.out.println(fractions(input));
    }
}
