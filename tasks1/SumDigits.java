import java.util.Scanner;

public class SumDigits{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String number = in.next();
        System.out.println(countSumDigits(number));
        in.close();
    }
    public static int countSumDigits(String number){
        int sumDigits = 0;
        for (int i = 0; i < number.length(); i++){
            sumDigits = sumDigits + (int) number.toCharArray()[i] - '0';
        }
        return sumDigits;
    } 
}