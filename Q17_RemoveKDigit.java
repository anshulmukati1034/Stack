import java.util.Stack;

public class Q17_RemoveKDigit {
     public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Stack → StringBuilder (reverse order me nikalna hoga)
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }

        // Leading zeros remove
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Empty ho gaya → "0" return
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k)); // Output: "1219"

        num = "10200";
        k = 1;
        System.out.println(removeKdigits(num, k)); // Output: "200"

        num = "10";
        k = 2;
        System.out.println(removeKdigits(num, k)); // Output: "0"
    }
}
