import java.util.Scanner;
import java.util.regex.*;

public class SecondLargest{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(secondLargest(in.nextLine()));
    }
    private static int secondLargest(String line){
        line = line.replace("[", "").replace("]", "");
        String[] arrStr = line.split(",");
        int[] arrInt = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i].strip());
        }
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arrInt.length; i++){
            if (arrInt[i] > max){
                max2 = max;
                max = arrInt[i];
            }
            else if (arrInt[i] > max2){
                max2 = arrInt[i];
            }
        }
        return max2;
        
    }
}