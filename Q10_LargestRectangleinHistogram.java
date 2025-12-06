import java.util.Stack;

public class Q10_LargestRectangleinHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] left = new int[n];   // NSL -> nearest smaller to left index
        int[] right = new int[n];  // NSR -> nearest smaller to right index

        Stack<Integer> st = new Stack<>();

        // --------------------
        // NSL (Nearest Smaller to Left)
        // --------------------
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();

            st.push(i);
        }

        // clear stack for NSR
        st.clear();

        // --------------------
        // NSR (Nearest Smaller to Right)
        // --------------------
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) right[i] = n;
            else right[i] = st.peek();

            st.push(i);
        }

        // --------------------
        // Compute max area
        // --------------------
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);
    }

}

