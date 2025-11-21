import java.util.Scanner;

public class CountWords {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(countWords(in.nextLine()));
    }
    private static int countWords(String line){
        String[] arrStr = line.split(" ");
        int count = 0;
        for (int i = 0; i < arrStr.length; i++){
            if (!"".equals(arrStr[i])){
                count+=1;
            }
        }
        return count;
    }
}