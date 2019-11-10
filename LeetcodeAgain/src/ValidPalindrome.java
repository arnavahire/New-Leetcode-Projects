public class ValidPalindrome {

    /* Brute Force */
    public boolean isPalindrome(String s) {
        /* \W matches non-word characters, so replace all of them by blank string and make the complete string in one case */
        String str = s.replaceAll("\\W","").toLowerCase();
        if(str.length() == 0)
            return true;

        int i=0;
        int j=str.length()-1;

        while(i<j)
        {
            if(str.charAt(i)==str.charAt(j))
            {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }

}
