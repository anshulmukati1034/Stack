import java.util.Stack;

public class Q18_SimplifyPath {
    public static String simplyStringPath(String path) {
         Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String s : parts) {
            if (s.equals("") || s.equals(".")) {
                continue; // ignore
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s); 
            }
        }

        // Build simplified path
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplyStringPath(path)); // Output: "/home"

        path = "/a/./b/../../c/";
        System.out.println(simplyStringPath(path)); // Output: "/c"

        path = "/../";
        System.out.println(simplyStringPath(path)); // Output: "/"

        path = "/home//foo/";
        System.out.println(simplyStringPath(path)); // Output: "/home/foo"
    }
}
