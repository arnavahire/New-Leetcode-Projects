import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        if(s.length()==0)
            return 0;

        s=s.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();

        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);

        int answer = 0;

        char[] character = s.toCharArray();
        for(int i=0;i<character.length;i++)
        {
            if(i==character.length-1)
                answer += map.get(character[i]);

            else if(map.get(character[i]) >= map.get(character[i+1]))
                answer += map.get(character[i]);

            else if(map.get(character[i]) < map.get(character[i+1]))
                answer -= map.get(character[i]);
        }

        return answer;
    }
}
