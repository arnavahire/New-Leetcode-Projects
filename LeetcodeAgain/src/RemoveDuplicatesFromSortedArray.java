public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int repCount = 0;

        for(int i=0;i<nums.length-1;i++)
        {
            //  if same element found, increase repCount

            if(nums[i]==nums[i+1]){
                repCount++;
            }

            // if different element found, replace the old element with new found element

            else{
                nums[i + 1 - repCount] = nums[i+1];
            }
        }

        return nums.length - repCount;
    }
}
