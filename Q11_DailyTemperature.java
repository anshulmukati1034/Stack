import java.util.Stack;

public class Q11_DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>(); // Stack will store indexes

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {

                int index = st.pop(); 
                ans[index] = i - index; 
            }

            st.push(i); 
        }

        // remaining indexes automatically remain 0
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);

        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}

