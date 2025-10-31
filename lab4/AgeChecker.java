import java.util.Scanner;

public class AgeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите ваш возраст: ");
            int age = scanner.nextInt();

            checkAge(age);

            System.out.println("Возраст принят: " + age + " лет.");

        } catch (CustomAgeException e) {
            System.out.println("Ошибка: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Неверный ввод! Пожалуйста, введите число.");
        } finally {
            scanner.close();
        }
    }

    public static void checkAge(int age) throws CustomAgeException {
        if (age < 0) {
            throw new CustomAgeException("Возраст не может быть отрицательным!");
        } else if (age > 120) {
            throw new CustomAgeException("Возраст не может быть больше 120 лет!");
        }
    }
}
