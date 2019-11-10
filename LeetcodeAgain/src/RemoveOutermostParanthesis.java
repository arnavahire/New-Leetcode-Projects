import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Logic : // run a for loop for length of string
           // iterate through all parentheses values
           // store first ( location as some val
           // assign 1 for "(" and -1 for ")"
           // if value is 0, then remove the first paren and most recent paren*/
public class RemoveOutermostParanthesis {

    /* Brute Force*/
    public String removeOuterParentheses(String S) {
        String result ="";
        StringBuilder sb = new StringBuilder();
        List<Character> primitiveString = new ArrayList<>();
        int count = 0;
        char[] sArray= S.toCharArray();
        for(int i=0;i<sArray.length;i++)
        {
            if(sArray[i]=='(')
            {
                count+=1;
                primitiveString.add(sArray[i]);
            }
            else if(sArray[i]==')')
            {
                count-=1;
                primitiveString.add(sArray[i]);
            }
            if(count==0)
            {
                primitiveString.remove(primitiveString.size()-1);
                primitiveString.remove(0);

                for(int x=0;x<primitiveString.size();x++)
                {
                    sb.append(primitiveString.get(x));
                }
                result += sb.toString();
                sb = new StringBuilder();
                primitiveString = new ArrayList<>();
            }
        }
        return result;
    }

    /* Optimized */
    public String removeOuterParentheses2(String S) {
        if(S==null || S.length()==0)
            return S;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] sArray= S.toCharArray();
        for(char c: S.toCharArray())
        {
            if(c=='(')
            {
                count++;
                if(count!=1)
                    sb.append(c);
            }
            if(c==')')
            {
                count--;
                if(count!=0)
                    sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParanthesis rop = new RemoveOutermostParanthesis();
        String s = "()()";
        String result = rop.removeOuterParentheses2(s);
        System.out.println(result);
    }
}
