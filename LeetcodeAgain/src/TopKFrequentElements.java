import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {

        // create a hashmap and store frequencies in that hashmap
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }

        // create a bucket of size nums.length +1 to store a list of numbers having same frequency
        List<Integer>[] bucket = new List[nums.length+1];

        for(Integer key : map.keySet())
        {
            if(bucket[map.get(key)]==null)
            {
                bucket[map.get(key)] = new ArrayList<Integer>();
                bucket[map.get(key)].add(key);
            }
            else
                bucket[map.get(key)].add(key);
        }

        // traverse the bucket from the end (because we want to go from highest frequency to lowest) to get the top k frequent elements

        List<Integer> output = new ArrayList<>();

        for(int i=bucket.length-1;i>0;i--)
        {
            if(bucket[i]==null)
                continue;
            else
            {
                if(k>0)
                {
                    for(int j=0;j<bucket[i].size();j++)
                    {
                        output.add(bucket[i].get(j));
                        k--;
                    }
                }
            }
        }
        return output;
    }

}
