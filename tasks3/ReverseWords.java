import java.util.Scanner;

public class ReverseWords{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(reverseWords(line));
    }
    private static StringBuilder reverseWords(String line){
        String[] wordArr = line.split(" ");
        StringBuilder reverseLine = new StringBuilder(250);
        for (int i = wordArr.length - 1; i > 0; i--){
            reverseLine.append(wordArr[i]+" ");
        }
        reverseLine.append(wordArr[0]);
        return reverseLine;
    }
}