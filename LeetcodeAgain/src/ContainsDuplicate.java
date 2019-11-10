import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /* First sort the array in ascending order*/
        Arrays.sort(nums);

        /*Now check that for element if the next element is the same as previos, if same, return duplicate as true*/
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]==nums[i+1])
                return true;
        return false;
    }
}
