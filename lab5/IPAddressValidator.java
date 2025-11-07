import java.util.Scanner;
import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите IP-адрес: ");
            String ip = scanner.nextLine();

            String zeroTo255 = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
            String ipPattern = "^(" + zeroTo255 + "\\.){3}" + zeroTo255 + "$";

            Pattern pattern = Pattern.compile(ipPattern);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP-адрес корректный.");
            } else {
                System.out.println("Некорректный IP-адрес!");
                System.out.println("IP-адрес должен содержать 4 числа от 0 до 255, разделённых точками.");
            }

        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getDescription());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
