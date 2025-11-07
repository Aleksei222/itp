import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            boolean isValid = true;

            if (password.length() < 8 || password.length() > 16) {
                System.out.println("Ошибка: длина пароля должна быть от 8 до 16 символов.");
                isValid = false;
            }

            if (!password.matches(".*[A-Z].*")) {
                System.out.println("Ошибка: пароль должен содержать хотя бы одну заглавную букву.");
                isValid = false;
            }

            if (!password.matches(".*\\d.*")) {
                System.out.println("Ошибка: пароль должен содержать хотя бы одну цифру.");
                isValid = false;
            }

            if (!password.matches("[A-Za-z0-9]+")) {
                System.out.println("Ошибка: пароль должен содержать только латинские буквы и цифры (без пробелов и символов).");
                isValid = false;
            }

            if (isValid) {
                System.out.println("Пароль корректный!");
            }

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
