import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int k=nums.length-1;

            if(i>0 && nums[i]==nums[i-1])
                continue;

            while(j < k)
            {
                if(k < nums.length - 1 && nums[k] == nums[k+1])
                {
                    k--;
                    continue;
                }

                if(nums[i]+nums[j]+nums[k] < 0)
                    j++;
                else if(nums[i]+nums[j]+nums[k] > 0)
                    k--;
                else
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    answer.add(list);
                    j++;
                    k--;
                }
            }
        }
        return answer;
    }
}
