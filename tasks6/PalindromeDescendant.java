import java.util.*;

public class PalindromeDescendant {

    public static boolean palindromeDescendant(int n) {
        String s = String.valueOf(n);
        while (s.length() > 1) {
            if (isPalindrome(s)) return true;
            if (s.length() % 2 != 0) break;
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2) {
                int sum = (s.charAt(i) - '0') + (s.charAt(i + 1) - '0');
                next.append(sum);
            }
            s = next.toString();
        }
        return isPalindrome(s);
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(palindromeDescendant(n));
    }
}