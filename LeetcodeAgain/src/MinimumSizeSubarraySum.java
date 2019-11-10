public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        //key:
        //1. keep track of the start index
        //2. once find one, recalulate min and remove elements from subarray so that sum < s
        //3. Time: O(n), Space: O(1)
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0;i< nums.length; i++)
        {
            sum+=nums[i];
            //need to remove  one or more elements until sum < s
            while(sum>=s)
            {
                //update the min size of subarray as needed
                min = Math.min(min, i - start +1);
                //remove the first element of subarray and move ahead to calculate the next s
                sum -= nums[start];
                start++;
            }
        }

        return min == Integer.MAX_VALUE? 0: min;
    }
}
