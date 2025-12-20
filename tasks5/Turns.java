import java.util.*;

public class Turns {

    public static int turns(int n) {
        int prevDigit = n % 10;
        n /= 10;

        int direction = 0;
        int count = 0;

        while (n > 0) {
            int currDigit = n % 10;

            if (currDigit != prevDigit) {
                int newDirection = currDigit < prevDigit ? 1 : -1;
                if (direction != 0 && newDirection != direction) {
                    count++;
                }
                direction = newDirection;
            }

            prevDigit = currDigit;
            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(turns(n));
    }
}
