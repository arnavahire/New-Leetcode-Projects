public class HouseRobber {

    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++)
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] arr={5, 3, 4, 11, 2};
        HouseRobber hr = new HouseRobber();
        int result = hr.rob(arr);
        System.out.println(result);

    }
}
