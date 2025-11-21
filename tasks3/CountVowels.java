import java.util.Scanner;
import java.util.regex.*;

public class CountVowels{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(countVowels(in.nextLine()));
    }
    private static int countVowels(String line){
        Pattern pattern = Pattern.compile("[aeiouAEIOU]");
        Matcher matcher = pattern.matcher(line);
        int count = 0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
}