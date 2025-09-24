public class Palindrome {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
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
        if (s.equals(reverseS)){
            return true;
        }
        return false;
    }
}