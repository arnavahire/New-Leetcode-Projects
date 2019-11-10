public class MissingNumber {

    /* Trick: Find out sum of 1st n natural numbers: ex: if nums = [1,2,3,4],
    sum would be 1+2+3+4 = 10 (n*(n+1))/2
    But our nums array has 0, so if our nums is nums = [0,1,2,4] the sum would be = 7
    then the missing number would be  -> 10 - 7 = 3
    */
    public int missingNumber(int[] nums) {
        int sum=0;

        /* calculate sum */
        for(int i=0;i<nums.length;i++)
        {
            sum+= nums[i];
        }

        /* calculate sum of first n natural numbers*/
        int n = nums.length;
        int sum_of_nat_no = (n*(n+1))/2;

        /* difference is the answer */
        return sum_of_nat_no - sum;
    }
}
