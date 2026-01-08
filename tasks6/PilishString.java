import java.util.*;

public class PilishString {

    public static String pilishString(String s) {
        int[] pi = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int len : pi) {
            if (index >= s.length()) break;
            int end = Math.min(index + len, s.length());
            String word = s.substring(index, end);
            while (word.length() < len) {
                word += word.charAt(word.length() - 1);
            }
            if (result.length() > 0) result.append(" ");
            result.append(word);
            index += len;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(pilishString(input));
    }
}
