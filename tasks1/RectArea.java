import java.util.Scanner;

public class RectArea {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        float a = in.nextFloat();
        float b = in.nextFloat();
        System.out.println(countArea(a, b));
        in.close();
    }
    public static float countArea(float a, float b){
        return a * b;
    }
}