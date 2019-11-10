import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        int c=0;
        int o=0;
        String s="";
        List<String> output = new ArrayList<>();
        helper(n, o, c, s, output);
        return output;
    }

    public void helper(int n, int o, int c, String s, List<String> output){
        if(o==n && c==n)
        {
            output.add(s);
            return;
        }

        if(o<n)
            helper(n , o+1, c, s+"(", output);

        // WE WANT ONLY SET OF VALID PARENTHESES.
        // HENCE C SHOULD ALWAYS BE LESS THAN 0,
        // ELSE IF  WE KEEP C<N, WE MAY GET A COMBINATION WHERE C > 0 THAT MEANS
        // THE CLOSED BRACKET WILL BE ADDED FIRST AND THEN THE OPEN WILL BE ADDED WHICH WE DONT WANT
        if(c<o)
            helper(n , o, c+1, s+")", output);
    }

    public static void main(String[] args) {
        GenerateParentheses gp=new GenerateParentheses();
        int n=3;
        List<String> result=gp.generateParenthesis(n);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }
}
