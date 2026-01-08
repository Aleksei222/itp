import java.util.*;

public class SortParams {

    public static String sortParams(String url) {
        int q = url.indexOf('?');
        if (q == -1) return url;

        String base = url.substring(0, q);
        String query = url.substring(q + 1);

        List<String[]> list = new ArrayList<>();

        for (String part : query.split("&")) {
            int eq = part.indexOf('=');
            if (eq == -1) continue;
            String key = part.substring(0, eq);
            String val = part.substring(eq + 1);
            if (!val.isEmpty()) {
                list.add(new String[]{key, val});
            }
        }

        if (list.isEmpty()) return base;

        list.sort((a, b) -> {
            if (a[1].length() != b[1].length()) {
                return a[1].length() - b[1].length();
            }
            return a[0].compareTo(b[0]);
        });

        StringBuilder res = new StringBuilder(base).append("?");
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) res.append("&");
            res.append(list.get(i)[0]).append("=").append(list.get(i)[1]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sortParams(sc.nextLine()));
    }
}

