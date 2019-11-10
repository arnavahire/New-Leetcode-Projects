import java.util.Stack;

/* This is a better solution for Valid Parenthesis than before. Refer this one. It's esier to understand*/
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s=="")
            return true;

        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length;i++)
        {
            if(input[i]=='{' || input[i]=='(' || input[i]=='[')
                stack.push(input[i]);
            else if(input[i]=='}')
            {
                if(stack.isEmpty() || stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            }
            else if(input[i]==')')
            {
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            }
            else if(input[i]==']')
            {
                if(stack.isEmpty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s="{}()[]";
        System.out.println("Valid Parenthesis ?: " + vp.isValid(s));
    }
}
