import java.util.Stack;

public class Q5_RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek() == ch) {
                st.pop(); // remove duplicate
            } else {
                st.push(ch); // push new char
            }
        }

        // stack → string (reverse)
        StringBuilder result = new StringBuilder();
        for (char c : st) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s)); // Output: "ca"

        s = "azxxzy";
        System.out.println(removeDuplicates(s)); // Output: "ay"
    }
   
}


