import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        Map<Character,String> map = new HashMap<>();
        map.put('a',".-");
        map.put('b',"-...");
        map.put('c',"-.-.");
        map.put('d',"-..");
        map.put('e',".");
        map.put('f',"..-.");
        map.put('g',"--.");
        map.put('h',"....");
        map.put('i',"..");
        map.put('j',".---");
        map.put('k',"-.-");
        map.put('l',".-..");
        map.put('m',"--");
        map.put('n',"-.");
        map.put('o',"---");
        map.put('p',".--.");
        map.put('q',"--.-");
        map.put('r',".-.");
        map.put('s',"...");
        map.put('t',"-");
        map.put('u',"..-");
        map.put('v',"...-");
        map.put('w',".--");
        map.put('x',"-..-");
        map.put('y',"-.--");
        map.put('z',"--..");
        Set<String> morseStringSet = new HashSet<>();
        for( String str : words)
        {
            str = str.toLowerCase();
            String morseString = "";
            for(int i=0;i<str.length();i++) {
                if (map.containsKey(str.charAt(i)))
                    morseString += map.get(str.charAt(i));
            }
            morseStringSet.add(morseString);
        }
        return morseStringSet.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords umcw = new UniqueMorseCodeWords();
        String[] arr = {"gin", "zen", "gig", "msg"};
        int result = umcw.uniqueMorseRepresentations(arr);
        System.out.println(result);
    }
}
