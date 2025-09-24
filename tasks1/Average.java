import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        System.out.println(average(a, b, c));
        in.close();
    }
    public static int average(int a, int b, int c){
        return (a + b + c) / 3;
    }
}