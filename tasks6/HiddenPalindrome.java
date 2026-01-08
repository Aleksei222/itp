import java.util.*;

public class HiddenPalindrome {

    public static String hiddenPalindrome(String s) {
        StringBuilder letters = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.append(Character.toLowerCase(c));
            }
        }

        String str = letters.toString();
        int n = str.length();
        String best = "";

        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int odd = 0;

            for (int j = i; j < n; j++) {
                int idx = str.charAt(j) - 'a';
                cnt[idx]++;
                if (cnt[idx] % 2 == 1) odd++;
                else odd--;

                int len = j - i + 1;
                if (len >= 2 && odd <= 1) {
                    if (len > best.length()) {
                        best = str.substring(i, j + 1);
                    }
                }
            }
        }

        return best.isEmpty() ? "none" : best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(hiddenPalindrome(sc.nextLine()));
    }
}
