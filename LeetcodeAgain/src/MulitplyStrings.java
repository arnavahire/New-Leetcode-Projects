public class MulitplyStrings {
    // solve this using a sum and use indices for both the multipliers and the results. The comparison will help understand the code better
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m+n];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = result[i+j+1] + mul;
                result[i+j] += sum / 10;
                result[i+j+1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.length;i++)
        {
            if(sb.length()==0 && result[i]==0) continue;  // for padded 0's we wont append them to final answer
            else sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
