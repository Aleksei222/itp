import java.util.Scanner;

public class Farenheit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int c = in.nextInt();
        System.out.println(toFarenheit(c));
        in.close();
    }
    public static int toFarenheit(int t){
        return t * 9 / 5 + 32;
    }
}