public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charToInteger = new int[26];

        for(int i=0;i<order.length();i++)
            charToInteger[order.charAt(i) - 'a'] = i;

        search : for(int i=0;i<words.length-1;i++)
        {
            String current = words[i];
            String next = words[i+1];

            for(int j=0;j<Math.min(current.length(), next.length());j++)
            {
                if(current.charAt(j)!=next.charAt(j))
                {
                    if(charToInteger[current.charAt(j)-'a'] > charToInteger[next.charAt(j)-'a'])
                        return false;
                    continue search;

                }
            }

            if(current.length() > next.length())
                return false;

        }

        return true;
    }
}
