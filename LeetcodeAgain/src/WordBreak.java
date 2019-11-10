import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp=new boolean[s.length()+1];  // we wil1 create a boolean array with 1 extra space to store the final boolean value

        dp[0]=true;                              // set 1st entry in dp array as true

        for(int i=1;i<dp.length;i++)       // begin i from 1st index and not 0th index
        {
            // we wil be iterating j from 0 to <i each time because we want to check against all true boolean values and not just the recent one
            for(int j=0;j<i;j++)
            {
                String subStr=s.substring(j,i);     // calculate substring from j to i (substring will exclude ith index element) and check if it lies in the dictionary and has boolean value at jth index as true
                if(wordDict.contains(subStr) && dp[j]==true)
                {
                    dp[i]=true;                         // if yes then set ith index value as true
                    break;
                }
                else                                    // else false
                    dp[i]=false;
            }
        }

        return dp[dp.length-1];            // return the final boolean value present at the ith index
    }
    public static void main(String[] args) {
        WordBreak wb=new WordBreak();
        String s="aaaaaaa";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        boolean result=wb.wordBreak(s,wordDict);
        System.out.println(result);
    }
}
