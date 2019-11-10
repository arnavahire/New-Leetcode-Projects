import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String res="";
        int index=0;
        while(index<s.length())
        {
            //if the character is digit, keep traversing untill all digits are finished, then enter the final number in stack
            if(Character.isDigit(s.charAt(index)))
            {
                int ct = 0;
                while(Character.isDigit(s.charAt(index)))
                {
                    ct=10*ct + (s.charAt(index)-'0');
                    index++;
                }
                numberStack.push(ct);
            }
            // if character is '[' save the current result in stack and reset result string so that we can add new string to the result
            else if(s.charAt(index)=='[')
            {
                stringStack.push(res);
                res="";
                index++;
            }
            // if character is ']' pop the saved string and append it to stringbuilder and add the new string to the popped until the number popped by number stack
            else if(s.charAt(index)==']')
            {
                StringBuilder sb = new StringBuilder(stringStack.pop());
                int count = numberStack.pop();
                for(int c=0;c<count;c++)
                    sb.append(res);
                res=sb.toString();
                index++;
            }
            // if it's alphabet, simply keep adding it to the resultant string
            else
            {
                res+=s.charAt(index);
                index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "3[a2[c]]";
        DecodeString ds =new DecodeString();
        System.out.println(ds.decodeString(str));
    }
}
