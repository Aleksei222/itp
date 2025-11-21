import java.util.Scanner;
import java.util.Arrays;

public class FilterEven{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(filterEven(in.nextLine()));
    }
    private static String filterEven(String line){
        line = line.replace("[", "").replace("]", "");
        String[] arrStr = line.split(",");
        int[] arrInt = new int[arrStr.length];
        int count = arrInt.length;
        for (int i = 0; i < arrStr.length; i++){
            arrInt[i] = Integer.parseInt(arrStr[i].strip());
            if (arrInt[i] % 2 != 0){
                count--;
            }
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i < arrInt.length; i++){
            if (arrInt[i] % 2 == 0){
                res[count] = arrInt[i];
                count++;
            }
        }
        return Arrays.toString(res);
    }
}