/* Logic: We will use windows starting from 0 to n-1 here.
For n=1, a string is palindrome of itself
For n=2, if element at i is equal to element at i+1, then it is also a palinndrome,
For n>= 3, if element at i and j are equal and the element at [i+1][j-1] are equal then its a palindrome*/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if(s.length()==0 || s.length()==1)
            return s;

        int n = s.length();
        boolean[][] matrix = new boolean[n][n];

        int start = 0;
        int end = 0;

        for(int i=0;i<n;i++)
        {
            matrix[i][i] = true;
            start = end = i;
        }

        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                matrix[i][i+1] = true;
                start = i;
                end =  i+1;
            }
            else
                matrix[i][i+1] = false;
        }

        int maxLength = 2;

        for(int k=3; k<n+1;k++)
        {
            for(int i=0;i<n-maxLength;i++)
            {
                int j = maxLength + i;

                if(s.charAt(i)==s.charAt(j))
                {
                    if(matrix[i+1][j-1]==true)
                    {
                        matrix[i][j] = true;
                        start = i;
                        end = j;
                    }
                    else
                        matrix[i][j] = false;
                }
                else
                    matrix[i][j] = false;
            }
            maxLength++;
        }

        return s.substring(start, end+1);
    }
}
