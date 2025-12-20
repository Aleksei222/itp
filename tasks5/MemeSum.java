import java.util.*;

public class MemeSum {

    public static String memeSum(int a, int b) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);

        int maxLen = Math.max(sa.length(), sb.length());
        sa = String.format("%" + maxLen + "s", sa).replace(' ', '0');
        sb = String.format("%" + maxLen + "s", sb).replace(' ', '0');

        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int sum = (sa.charAt(i) - '0') + (sb.charAt(i) - '0');
            sbResult.append(sum);
        }
        return sbResult.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(",");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());

        System.out.println(memeSum(a, b));
    }
}
