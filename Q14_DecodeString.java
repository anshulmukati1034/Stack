import java.util.Stack;

public class Q14_DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String current = "";
        int num = 0;

        for (char ch : s.toCharArray()) {

            // If digit → build number (can be 2, 12, 100)
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If '[' → push number and current string into stacks
            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);

                num = 0;
                current = "";
            }

            // If ']' → pop number and previous string, then repeat
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());

                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }

                current = temp.toString();
            }

            // If normal character → add to current block
            else {
                current += ch;
            }
        }

        return current;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s)); // Output: aaabcbc

        s = "3[a2[c]]";
        System.out.println(decodeString(s)); // Output: accaccacc

        s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s)); // Output: abcabccdcdcdef

        s = "10[a]";
        System.out.println(decodeString(s)); // Output: aaaaaaaaaa
    }
}


