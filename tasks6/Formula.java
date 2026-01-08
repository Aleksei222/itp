import java.util.*;

public class Formula {

    public static boolean formula(String s) {
        String[] parts = s.split("=");
        double prev = evaluate(parts[0].trim());

        for (int i = 1; i < parts.length; i++) {
            double current = evaluate(parts[i].trim());
            if (Math.abs(prev - current) > 1e-9) return false;
            prev = current;
        }
        return true;
    }

    private static double evaluate(String expr) {
        expr = expr.replaceAll("\\s+", "");
        return parseExpression(expr);
    }

    private static double parseExpression(String expr) {
        return new Parser(expr).parse();
    }

    private static class Parser {
        private final String expr;
        private int pos = -1, ch;

        Parser(String expr) {
            this.expr = expr;
        }

        void nextChar() {
            ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            if (ch == charToEat) { nextChar(); return true; }
            return false;
        }

        double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < expr.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        double parseExpression() {
            double x = parseTerm();
            for (;;) {
                if (eat('+')) x += parseTerm();
                else if (eat('-')) x -= parseTerm();
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            for (;;) {
                if (eat('*')) x *= parseFactor();
                else if (eat('/')) x /= parseFactor();
                else return x;
            }
        }

        double parseFactor() {
            if (eat('+')) return parseFactor();
            if (eat('-')) return -parseFactor();

            int startPos = this.pos;
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            if (startPos == this.pos) throw new RuntimeException("Unexpected: " + (char)ch);
            return Double.parseDouble(expr.substring(startPos, this.pos));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(formula(input));
    }
}
