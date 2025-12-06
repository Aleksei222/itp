import java.util.Scanner;

public class NonRepeat {

    public static String nonRepeat(String s) {
        int[] freq = new int[256];
        countFreq(s.toLowerCase(), 0, freq);
        return buildResult(s, 0, freq);
    }

    private static void countFreq(String s, int i, int[] freq) {
        if (i == s.length()) return;
        freq[s.charAt(i)]++;
        countFreq(s, i + 1, freq);
    }

    private static String buildResult(String s, int i, int[] freq) {
        if (i == s.length()) return "";

        char c = s.charAt(i);
        char low = Character.toLowerCase(c);

        if (freq[low] > 3) {
            return buildResult(s, i + 1, freq);
        }

        return c + buildResult(s, i + 1, freq);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(nonRepeat(input));
    }
}
