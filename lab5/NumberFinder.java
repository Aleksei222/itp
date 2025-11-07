import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price is 19.99 dollars, and the quantity is 25 items. Also: 100, 0.5 and 42";

            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные числа:");

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении!");
            System.out.println("Подробности: " + e.getDescription());

        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста!");
            System.out.println("Подробности: " + e.getMessage());
        }
    }
}
