import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int count = 0;
        int flag = 0;
        Map<Integer, List<Character>> map = new LinkedHashMap<>(); // using LinkedHashMap because order of insertion will be maintained unlike regular hashmap
        for(int i=0; i< s.length(); i++)
        {
            // if count becomes numRows - 1, we will reduce the count
            if(count == numRows - 1)
                flag = 1;
                // if count becomes 0, we will increase the count
            else if(count == 0)
                flag = 0;

            // if map already countains count, then we simply keep appending elements to the corr. list
            if(map.containsKey(count))
                map.get(count).add(s.charAt(i));
            else
            {
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(i));
                map.put(count, list);
            }

            if(flag==1)
                count--;
            else
                count++;
        }

        // take elements from lists of all counts, count by count and append to final solution
        StringBuilder sb = new StringBuilder();
        for(int key: map.keySet())
        {
            for(Character c : map.get(key))
                sb.append(c);
        }

        return sb.toString();
    }
}
