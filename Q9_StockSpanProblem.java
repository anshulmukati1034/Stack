import java.util.ArrayList;
import java.util.Stack;

public class Q9_StockSpanProblem {

    public static ArrayList<Integer> stockSpan(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Pop until you find greater element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // If stack empty → no greater in left → span = i + 1
            if (s.isEmpty()) {
                result.add(i + 1);
            }
            // Otherwise span = current index - index of last greater element
            else {
                result.add(i - s.peek());
            }

            // Push current index onto stack
            s.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> res = stockSpan(arr);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
