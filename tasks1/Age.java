import java.util.Scanner;

public class Age {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        System.out.println(checkAge(age));
        in.close();
    }
    public static String checkAge(int age){
        if (age>=18) {
            return "совершеннолетний";
        }
        else {
            return "несовершеннолетний";
        }
    }
}