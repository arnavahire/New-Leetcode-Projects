import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s == null)
            return 0;


        // use sliding window technique which uses 2 pointers to maintain a window
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;
        int maxCount = 0;

        // if character is not present in set, add it to the set and increment j and reset maxCount. If character is already present,
        // then remove the element at the ith index from the set and increment i
        while(j<s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
                set.add(s.charAt(j));
                j++;
                maxCount = Math.max(maxCount, j-i);
            }
            else
            {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxCount;
    }
}
