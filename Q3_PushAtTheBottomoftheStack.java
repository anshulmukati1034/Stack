import java.util.Stack;

public class Q3_PushAtTheBottomoftheStack {
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Original Stack: " + s);

        pushAtBottom(s, 5);

        System.out.println("Stack after pushing 5 at bottom: " + s);
    }
}
