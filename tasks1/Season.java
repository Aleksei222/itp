import java.util.Scanner;

public class Season{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();
        System.out.println(season(number));
    }
    public static String season(int number){
        if (number > 2 && number < 6){
            return "весна";
        }
        else if (number > 5 && number < 9){
            return "лето";
        }
        else if (number > 8 && number < 12){
            return "осень";
        }
        else {
            return "зима";
        }
    }
}