import java.util.Stack;

public class Q15_BasicCalculator2 {
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If number, build it
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            }

            // If operator or last character
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    stack.push(currentNum);
                } else if (lastSign == '-') {
                    stack.push(-currentNum);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / currentNum);
                }

                lastSign = ch;
                currentNum = 0;
            }
        }

        // Sum all stack values
        int result = 0;
        for (int val : stack) result += val;

        return result;
    }

    public static void main(String[] args) {
        String expression = "3+2*2";
        System.out.println(calculate(expression)); // Output: 7

        expression = " 3/2 ";
        System.out.println(calculate(expression)); // Output: 1

        expression = " 3+5 / 2 ";
        System.out.println(calculate(expression)); // Output: 5
    }

}
