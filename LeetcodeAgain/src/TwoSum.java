import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // Create a hashmap that stores the element and it's index
        Map<Integer, Integer> map = new HashMap<>();

        // for every entry, we will check if the complement is present in the hashmap, if yes, we will return the indices of complement and the current entry. If not, we will add an entry to hashmap
        for(int i=0;i<nums.length;i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[] {map.get(complement), i};
            else
                map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] arr = {3,4,21,16,1,17};
        int target = 38;
        int[] res = ts.twoSum(arr, target);
        System.out.println("Result: "+ res[0] + " " + res[1]);
    }
}
