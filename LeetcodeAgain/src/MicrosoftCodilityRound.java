import java.util.*;

public class MicrosoftCodilityRound {

    /*Write a function smallestString that given a string S consisting of N characters, returns the alphabetically smallest string that can be obtained by removing
     exactly one word from S
     Ex: S="acb", then answer will be "ab" since c is lexicographically bigger than b and hence "ab" would be smaller than "ac" and "bc".
     Ex:2 S="codility" then answer will be "cdility" because cdility would come first lexicographically compared to "codility" */

    public String smallestString(String str){
        if(str==null|| str=="")
            return "";

        char[] chArray =  str.toCharArray();

        // create a list of characters that are lexicographically sorted and use it for lookup
        List<Character> lookupList = new ArrayList<>();
        for(char c : chArray)
            lookupList.add(c);

        Collections.sort(lookupList, new Comparator<Character>(){
            public int compare(Character c1, Character c2)
            {
                return c1.compareTo(c2);
            }
        });

        int index = 0;  // we set the value of index to that element's index value which is lexicographically bigger than the next character
        int skipCount = 0; // we increment this count each time we encounter that the current character is lexicographically smaller than the next
        for(int i=0;i<chArray.length-1;i++)
        {
            int currentIndex = lookupList.indexOf(chArray[i]);
            int nextIndex =  lookupList.indexOf(chArray[i+1]);
            if(nextIndex > currentIndex)
            {
                skipCount++;
                continue;
            }
            else {
                index = i;
                break;
            }
        }

        // if index is still 0 and skipCount = charray.length-1 means that we reached the end of the word and its prefectly lexicographically ordered, hence we will remove the last element
        if(skipCount==chArray.length-1 && index==0)
            index=skipCount;

        StringBuilder sb = new StringBuilder();

        // skip the character pointed by 'index' value
        for(int i=0; i<chArray.length;i++)
        {
            if(i!=index)
                sb.append(chArray[i]);
        }

        return sb.toString();
    }

    /* Problem: Remove least number of letters making string no 3 or more consecutive and identical letters
    Ex: aabbbbdddes -> aabbddes . So here the count will be 3 since we will remove 2 b's and 1 d */
    public int numberOfLetters(String str)
    {
        int removeCount = 0;  // keeps track of the count of number of letters to be removed when currentCount exceeds or equals 3
        int currentCount = 0; // keeps track of current character's count

        Set<Character>  charSet = new HashSet<>();

        for(int i=0;i<str.length();i++)
        {
            if(!charSet.contains(str.charAt(i))) // if set doesn't contain the element, reset currentCount and start incrementing again
            {
                charSet.add(str.charAt(i));
                currentCount = 0;
                currentCount++;
            }
            else {                     // if set contains the element, increase currentCount. If it equals or is greater than 3, increment removeCount
                currentCount++;
                if (currentCount >= 3) {
                    removeCount++;
                }
            }
        }

        return removeCount;
    }

    /* Problem: In a string containing uppercase and lowercase letters, look for the one with highest case in uppercase and lowercase.
    Ex: aRnAV - > nV here n is highest amongts lowercase and V is highest amongst upper */
    public String highestUppercaseAndLowercaseLetters(String str)
    {
        int upperMax = Integer.MIN_VALUE;
        int lowerMax = Integer.MIN_VALUE;
        String upperMaxChar="";
        String lowerMaxChar="";

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)-'a' >= 0)            // if it's a lowercase letter, find max in lowercase
            {
                if(lowerMax < str.charAt(i)-'a')
                {
                    lowerMax = str.charAt(i)-'a';
                    lowerMaxChar = str.charAt(i)+"";
                }
            }
            else                // if it's an uppercase, find max in uppercase
            {
                if(upperMax < str.charAt(i)-'A')
                {
                    upperMax = str.charAt(i)-'A';
                    upperMaxChar = str.charAt(i)+"";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lowerMaxChar);
        sb.append(upperMaxChar);

        return sb.toString();
    }

    /* Problem : In a string of upper and lower case characters, find the highest character found in any case
    Ex: aXNav -> X since 'X' -'A' gives us the max difference of 23 (88 - 65) */
    public String highestInAllCaseLetters(String str)
    {
        int max = Integer.MIN_VALUE;
        String maxChar="";

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)-'a' >= 0)            // if it's a lowercase letter, find max in lowercase
            {
                if(max < str.charAt(i)-'a')
                {
                    max = str.charAt(i)-'a';
                    maxChar = str.charAt(i)+"";
                }
            }
            else                // if it's an uppercase, find max in uppercase
            {
                if(max < str.charAt(i)-'A')
                {
                    max = str.charAt(i)-'A';
                    maxChar = str.charAt(i)+"";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxChar);

        return sb.toString();
    }

    public static void main(String[] args) {
        MicrosoftCodilityRound mcr = new MicrosoftCodilityRound();
        String str = "codility";
        System.out.println(mcr.smallestString(str));
        String str2 = "aabbbbdddes";
        System.out.println(mcr.numberOfLetters(str2));
        String str3 = "arnAV";
        System.out.println(mcr.highestUppercaseAndLowercaseLetters(str3));
        String str4 = "axnAV";
        System.out.println(mcr.highestInAllCaseLetters(str4));
    }

}
