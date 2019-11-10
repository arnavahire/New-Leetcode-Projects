import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length()==0)
            return result;

        // map each index to a string. ex: index 2 will map to "abc" which is wht we want since on phone 2 maps to abc. We wil use dummy values for 0 and 1 since they do not have letters
        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz",
        };

        helper(result, digits, 0, "", mapping);
        return result;
    }

    public void helper(List<String> result, String digits, int index, String combination, String[] mapping)
    {
        if(index == digits.length())       // when index value equals digits lentgh that means u reached end of input, so add result to final list and return
        {
            result.add(combination);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0']; // find the letters of the number pointer by 'index'

        for(int i=0;i<letters.length();i++)  // for each letter, increment index and add the current letter to combination and recursively call helper method
        {
            helper(result, digits, index + 1, combination + letters.charAt(i), mapping);
        }
    }
}
