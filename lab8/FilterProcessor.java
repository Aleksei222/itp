public class FilterProcessor {

    @DataProcessor
    public String filterOdd(String s) {
        if (s.matches(".*-*[13579]$")) {
            return "";
        }
        return s;
    }
}