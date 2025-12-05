import java.util.ArrayList;
import java.util.Stack;

public class Q7_NearestGreatherToLeft {

    public static ArrayList<Integer> printNGR(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {

            // If stack empty → no greater element
            if (s.isEmpty()) {
                result.add(-1);
            }
            // If top > current → it is next greater
            else if (s.peek() > arr[i]) {
                result.add(s.peek());
            }
            // If top <= current → pop until you find greater
            else if (!s.isEmpty() &&s.peek() <= arr[i]) {
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }

                if (s.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(s.peek());
                }
            }

            // Push current element
            s.push(arr[i]);
        }

        // reverse the result
       
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 10, 8};
        ArrayList<Integer> res = printNGR(arr);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
