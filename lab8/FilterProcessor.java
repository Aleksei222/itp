public class FilterProcessor {

    @DataProcessor
    public String filterOdd(String s) {
        // Убираем строки с нечётными индексами (имитация)
        if (s.matches(".*-*[13579]$")) {
            return "";
        }
        return s;
    }
}