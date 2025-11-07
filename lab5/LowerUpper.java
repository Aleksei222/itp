import java.util.regex.*;

public class LowerUpper {
    public static void main(String[] args) {
        String text = "verY iNterEsting StRing";


        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll("$1!$2!");

        System.out.println("Исходный текст: " + text);
        System.out.println("Результат:      " + result);
    }
}
