import java.util.Scanner;
import java.util.Arrays; 

public class IsAnagram {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(isAnagram(in.nextLine()));
    }
    private static boolean isAnagram(String line){
        String[] arr = line.split(",");
        arr[1] = arr[1].strip();
        if (arr[0].length() != arr[1].length()){
            return false;
        }
        arr[0] = arr[0].toLowerCase();
        arr[1] = arr[1].toLowerCase();
        char[] str1 = arr[0].toCharArray();
        char[] str2 = arr[1].toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        if (Arrays.equals(str1, str2)){
            return true;
        }else {
            return false;
        }
    }
}