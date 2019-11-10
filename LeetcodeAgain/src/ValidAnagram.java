import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /* Brute Force */
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        char[] sArray = s.toCharArray();

        for(int i=0;i<sArray.length;i++)
        {
            if(map.containsKey(sArray[i]))
                map.put(sArray[i], map.get(sArray[i])+1);
            else
                map.put(sArray[i], 1);
        }

        char[] tArray = t.toCharArray();

        for(int i=0;i<tArray.length;i++)
        {
            if(map.containsKey(tArray[i]))
                map.put(tArray[i], map.get(tArray[i])-1);
            else
                return false;
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()!=0)
                return false;
        }

        return true;
    }

    /* Optimized*/


}
