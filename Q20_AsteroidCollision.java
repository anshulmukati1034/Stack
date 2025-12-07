import java.util.Stack;

public class Q20_AsteroidCollision {
     public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {

            boolean destroyed = false;

            // collision possible only when st.top > 0 and a < 0
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.peek();

                if (top < -a) {
                    st.pop();         // top destroyed
                } else if (top == -a) {
                    st.pop();         // both destroy
                    destroyed = true; 
                    break;
                } else {
                    destroyed = true; // current asteroid destroyed
                    break;
                }
            }

            if (!destroyed) st.push(a);
        }

        // convert stack to array
        int[] res = new int[st.size()];
        for (int i = 0; i < res.length; i++) res[i] = st.get(i);
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        // Output: [5, 10]
        for (int r : result) System.out.print(r + " ");
        System.out.println();
    }
}
