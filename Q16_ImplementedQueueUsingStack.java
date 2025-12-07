import java.util.LinkedList;
import java.util.Queue;

public class Q16_ImplementedQueueUsingStack {
    private static Queue<Integer> q = new LinkedList<>();
    

    public static void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public static int pop() {
        return q.poll();
    }

    public static int top() {
        return q.peek();
    }

    public static boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {    
        push(1);
        push(2);
        System.out.println(top());   // returns 2
        System.out.println(pop());   // returns 2
        System.out.println(empty()); // returns false
    }
}
