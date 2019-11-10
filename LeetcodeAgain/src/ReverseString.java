public class ReverseString {

    public char[] reverseString(char[] s) {
        int n= s.length;
        for(int i=0;i<(n/2);i++)
        {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
        return s;
    }

    public static void main(String[] args) {
        char[] arr={'h','e','l','l','o','i'};
        ReverseString rs= new ReverseString();
        char[] str = rs.reverseString(arr);
        System.out.println(str);
    }
}
