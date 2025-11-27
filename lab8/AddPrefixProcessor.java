public class AddPrefixProcessor {

    @DataProcessor
    public String addPrefix(String s) {
        return "Processed-" + s;
    }
}

