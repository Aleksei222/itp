import java.io.*;

public class FileCopy {
    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";


        try (
            FileInputStream input = new FileInputStream(inputFile);
            FileOutputStream output = new FileOutputStream(outputFile)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл успешно скопирован из \"" + inputFile + "\" в \"" + outputFile + "\"");

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден!");
            System.out.println("Подробности: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла!");
            System.out.println("Подробности: " + e.getMessage());
        }
    }
}
