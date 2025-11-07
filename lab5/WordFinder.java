import java.util.Scanner;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите текст: ");
            String text = scanner.nextLine();

            System.out.print("Введите букву, с которой должны начинаться слова: ");
            String letter = scanner.nextLine();

            if (!letter.matches("[A-Za-zА-Яа-я]")) {
                throw new IllegalArgumentException("Можно вводить только одну букву.");
            }

            Pattern pattern = Pattern.compile("\\b" + letter + "\\w*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            boolean found = false;
            System.out.println("Слова, начинающиеся с '" + letter + "':");

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Таких слов не найдено.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
