import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            System.out.println(isPrime(n));
            in.close();
        
    }
    public static boolean isPrime(int n) {
        if (n == 2){
            return true;
        }
        for (int i = 2; i < Math.sqrt(n) + 1; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}