import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        char[] charArray = alphabets.toCharArray();
        List<String> result = new ArrayList<>();
        for(int j=0;j<charArray.length;j++)
        {
            int count = 0;
            for(int i=0;i<A.length;i++)
            {
                char[] chArray = A[i].toCharArray();
                for(int k=0;k<chArray.length;k++)
                {
                    if(charArray[j]==chArray[k])
                        count++;
                }
            }
            if(count == A.length)
                result.add(String.valueOf(charArray[j]));
        }
        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters fcc = new FindCommonCharacters();
        String[] arr = {"bella","label","roller"};
        List<String> result = fcc.commonChars(arr);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i)+" ");
    }
}
