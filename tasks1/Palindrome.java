import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        System.out.println(isPalindrome(s));
    }
    public static String reverseString(String s){
        String result = "";
        int len = s.length();
        for (int i = len - 1; i >= 0; i--){
            result = result + s.charAt(i);
        }
        return result;
    }
    public static boolean isPalindrome(String s){
        String reverseS = reverseString(s);
        return s.equals(reverseS);
    }
}