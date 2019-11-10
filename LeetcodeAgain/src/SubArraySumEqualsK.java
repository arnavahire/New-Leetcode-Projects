import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count=0;

        for(int start=0;start<nums.length;start++)
        {
            int sum=0;
            for(int end=start;end<nums.length;end++)
            {
                sum+=nums[end];
                if(sum==k)
                    count++;
            }
        }

        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int complement = sum-k;
            if(map.containsKey(complement))
            {
                count+=map.get(complement);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0};
        int k=0;
        SubArraySumEqualsK sase = new SubArraySumEqualsK();
        System.out.println("O/P: "+sase.subarraySum2(arr, k));
    }
}
