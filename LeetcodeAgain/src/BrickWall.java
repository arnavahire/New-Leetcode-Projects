import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>();

        // basically for every brick wall, if sum is same for 2 levels of bricks, the line won't cut the bricks. We need to find max such levels who have same sum
        for(List<Integer> row : wall)
        {
            int sum = 0;

            for(int i=0;i<row.size()-1;i++) // iterate till 2nd last element of each row because after the last element they wil have same boundaries
            {
                sum+=row.get(i);     // calculate sum for each row and store the sum as key, and it's frequency as value in map

                if(!map.containsKey(sum))
                    map.put(sum, 1);   // if not present set 1
                else
                    map.put(sum, map.get(sum)+1);  // if present increase frequency by 1
            }
        }

        int res = wall.size();  // initially result will be wal.size i.e it will cut through all bricks

        for(int key: map.keySet())
            res = Math.min(res, wall.size() - map.get(key));  // the greater the frequency value of sum, the lesser bricks will be cut

        return res;
    }

    public static void main(String[] args) {
        BrickWall bw = new BrickWall();

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(1);
        l2.add(2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(3);
        l3.add(2);

        List<Integer> l4 = new ArrayList<>();
        l4.add(2);
        l4.add(4);

        List<Integer> l5 = new ArrayList<>();
        l5.add(3);
        l5.add(1);
        l5.add(2);

        List<Integer> l6 = new ArrayList<>();
        l6.add(1);
        l6.add(3);
        l6.add(3);
        l6.add(1);

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        list.add(l5);
        list.add(l6);

        System.out.println("Ans: "+bw.leastBricks(list));
    }
}
