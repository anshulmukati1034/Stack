import java.util.Stack;

public class Q13_ValidParenthesis {
   
    public static boolean isValid(String s) {
        Stack<Character>str=new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='[' || ch=='{'){//opening
                str.push(ch);
            }
            else{
                if(str.isEmpty()){
                    return false;
                }
                if((str.peek()=='(' && ch==')')//()
                || (str.peek()=='{' && ch=='}')//{}
                || (str.peek()=='[' && ch==']')){//[]
                    str.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(str.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValid(s)); // Output: true

        s = "{[(])}";
        System.out.println(isValid(s)); // Output: false

        s = "{{[[(())]]}}";
        System.out.println(isValid(s)); // Output: true
    }
}

