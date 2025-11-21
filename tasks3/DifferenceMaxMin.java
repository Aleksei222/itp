import java.util.Scanner;
import java.util.regex.*;

public class DifferenceMaxMin{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(differenceMaxMin(in.nextLine()));
    }
    private static int differenceMaxMin(String line){
        line = line.replace("[", "").replace("]", "");
        String[] arrStr = line.split(",");
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i].strip());
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrInt.length; i++){
            if (arrInt[i] > max){
                max = arrInt[i];
            }
            if (arrInt[i] < min){
                min = arrInt[i];
            }
        }
        return max - min;
        
    }
}