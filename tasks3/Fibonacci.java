import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(fibonacci(in.nextInt()));
    }
    private static int fibonacci(int number){
        if (number == 0){
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}