public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];

        // create first array that stores product of all elements to the left of index i
        //ex: [1,2,3,4] , left = [1, 1, 2, 6]
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
                left[i] = 1;  // for first index the left[i] will always be 1
            else
                left[i] = nums[i-1] * left[i-1];
        }

        // create second array that stores product of all elements to the right of index i
        // ex: [1,2 3,4], right = [24 ,12, 4, 1]
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
                right[i] = 1; // for last index the right[i] will always be 1
            else
                right[i] = nums[i+1] * right[i+1];
        }

        // final answer will be product of left and right array at every index
        for(int i=0;i<nums.length;i++)
            answer[i] = left[i] * right[i];

        return answer;
    }
}
