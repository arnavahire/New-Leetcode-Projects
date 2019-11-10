import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    /*Brute Force*/
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cArr = s.toCharArray();
        for(int i=0;i<cArr.length;i++)
        {
            if(map.containsKey(cArr[i]))
                map.put(cArr[i], map.get(cArr[i])+1);
            else
                map.put(cArr[i], 1);
        }

        for(int i=0;i<cArr.length;i++)
        {
            if(map.containsKey(cArr[i]) &&map.get(cArr[i])==1)
                return i;
        }
        return -1;
    }
}
