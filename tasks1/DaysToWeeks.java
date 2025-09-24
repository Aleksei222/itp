import java.util.Scanner;

public class DaysToWeeks {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        System.out.println(daysToWeeks(days));
        in.close();
    }
    public static String daysToWeeks(int days){
        int weeks = days / 7;
        days = days % 7;
        String r1;
        String r2;
        if (weeks == 1){
            r1 = String.valueOf(weeks).concat(" неделя и ");
        }
        else if (weeks % 10 == 0 || weeks % 10 > 4) {
            r1 = String.valueOf(weeks).concat(" недель и ");
        }
        else {
            r1 = String.valueOf(weeks).concat(" недели  и ");
        }
        if (days == 1){
            r2 = String.valueOf(days).concat(" день");
        }
        else if (days % 10 == 0 || days % 10 > 4) {
            r2 = String.valueOf(days).concat(" дней");
        }
        else {
            r2 = String.valueOf(days).concat(" дня");
        }
        return r1.concat(r2);      
    }
}