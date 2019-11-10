public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if( s==null || s.length() == 0 )
            return "";

        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        // Traverse from the end to start
        // if the current char isn't space then set the end point and traverse back till you find the next space and then extract the substring till the current i index, else if its a space just keep traversing
        while(i >= 0)
        {
            if(s.charAt(i)!=' ')
            {
                int end = i;

                while( i-1 >= 0 && s.charAt(i-1)!=' ')
                    i--;

                sb.append(s.substring(i, end+1) + " ");
            }
            i--;
        }

        if(sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString rwias = new ReverseWordsInAString();
        String str = "  hello world!  ";
        System.out.println("\""+rwias.reverseWords(str)+"\"");
    }
}
