import java.util.Stack;

public class Q19_MinStack {
    
    public static Stack<Integer> stack = new Stack<>();
    public static int min = Integer.MAX_VALUE;

    public static void push(int x) {
        // If new value is smaller than current min
        if (x <= min) {
            // store previous min into stack
            stack.push(min);
            // update min
            min = x;
        }
        stack.push(x);
    }

    public static void pop() {
        int removed = stack.pop();

        // If popped value is the current min
        if (removed == min) {
            // previous min wapas lao
            min = stack.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return min;
    }

    public static void main(String[] args) {
        push(-2);
        push(0);
        push(-3);
        System.out.println(getMin()); // Returns -3
        pop();
        System.out.println(top());    // Returns 0
        System.out.println(getMin()); // Returns -2
    }
}


