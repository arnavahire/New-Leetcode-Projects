import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(S.length() > 50 || J.length() > 50)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<S.length();i++)
        {
            if(map.containsKey(S.charAt(i)))
                map.put(S.charAt(i), map.get(S.charAt(i))+1);
            else
                map.put(S.charAt(i), 1);
        }
        int sum=0;
        for(int i=0;i<J.length();i++)
        {
            if(map.containsKey(J.charAt(i)))
                sum+=map.get(J.charAt(i));
        }
        return sum;
    }

    /* Using HashSet */
    public int numJewelsInStonesUsingHashSet(String J, String S) {
        if(S.length() > 50 || J.length() > 50)
            return 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<J.length();i++)
            set.add(J.charAt(i));

        int count = 0;

        for(int i=0;i<S.length();i++)
        {
            if(set.contains(S.charAt(i)))
                count++;
        }

        return count;
    }
    public static void main(String[] args) {
        String jewel = "aA";
        String stones = "aAAbbbb";
        JewelsAndStones jns = new JewelsAndStones();
        int result = jns.numJewelsInStones(jewel, stones);
        System.out.println(result);
    }
}
