import java.util.Scanner;

public class Even{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(isEven(number));
        in.close();
    }
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}