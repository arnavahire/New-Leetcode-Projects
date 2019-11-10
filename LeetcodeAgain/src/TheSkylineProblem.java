import java.util.*;


/* If stuck, check Tushar roy's explanation on youtube */
public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);  // max priority queue that will store max height

        for(int[] building: buildings)
        {
            list.add(new int[] {building[0], -building[2]} ); // we use - height for indicating start
            list.add(new int[] {building[1], building[2]});  // and + height for indicating end
        }

        Collections.sort(list, (a, b) -> {                 // sort the list so that in case of same x co-ordinate we always have elements with start marked before end
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        queue.offer(0);   // initial max will be 0 in the queue
        int max = Integer.MIN_VALUE;  // variable to check whether the height of skyline changes, if yes then we add that co-ordinate to skyline
        for(int[] height : list)
        {
            if(height[1] < 0) queue.offer(-height[1]); // if start, then we add the negative of height cause it will then become +ve
            else
                queue.remove(height[1]);  // if we reach the end of building, remove it's height from skyline

            if(max!=queue.peek())
            {
                max = queue.peek();       // if max changes, reset the max value to the one returned by queue
                answer.add(new ArrayList<>(Arrays.asList(height[0], max))); // new height will be (x co-ordinate , max)
            }
        }
        return answer;
    }
}
