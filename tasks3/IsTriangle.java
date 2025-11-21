import java.util.Scanner;
import java.util.regex.*;

public class DifferenceMaxMin{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(differenceMaxMin(in.nextLine()));
    }
    private static boolean differenceMaxMin(String line){
        String[] arrStr = line.split(",");
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i].strip());
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arrInt.length; i++){
            if (arrInt[i] > max){
                max = arrInt[i];
            }
            sum += arrInt[i];
        }
        return sum - max > max;
        
    }
}