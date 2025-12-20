import java.util.*;

public class DeepFlatten {

    public static List<Integer> deepFlatten(Object obj) {
        List<Integer> result = new ArrayList<>();
        if (obj instanceof Integer) {
            result.add((Integer) obj);
        } else if (obj instanceof List) {
            for (Object o : (List<?>) obj) {
                result.addAll(deepFlatten(o));
            }
        }
        return result;
    }

    private static Object parse(String s) {
        Stack<List<Object>> stack = new Stack<>();
        List<Object> current = new ArrayList<>();
        stack.push(current);

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                List<Object> list = new ArrayList<>();
                stack.peek().add(list);
                stack.push(list);
                i++;
            } else if (c == ']') {
                stack.pop();
                i++;
            } else if (c == '-' || Character.isDigit(c)) {
                int sign = 1;
                if (c == '-') {
                    sign = -1;
                    i++;
                }
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.peek().add(num * sign);
            } else {
                i++;
            }
        }
        return current.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("\\s+", "");
        Object parsed = parse(input);
        List<Integer> flat = deepFlatten(parsed);

        System.out.print("[");
        for (int i = 0; i < flat.size(); i++) {
            System.out.print(flat.get(i));
            if (i != flat.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
