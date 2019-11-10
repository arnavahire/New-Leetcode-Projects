import java.util.*;

public class MergeIntervals {

    /* By using a list and creating a new data structure */

    class Interval {
        int start;
        int end;

        Interval(int s, int e){
            start = s;
            end = e;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> intervalList = new ArrayList<>();

        // return the list as it is if the list size is <=1
        if(intervals.size()<=1)
            return intervals;

        // sort the intervals by start time
        intervals.sort((interval1,interval2)-> Integer.compare(interval1.start, interval2.start));

        // Get the start and end of the first interval
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        // Compare the starts and ends of intervals starting from the 2nd interval
        for(int i=1; i<=intervals.size();i++)
        {
            // merge interval which has start and end both less than the current start and end
            if(intervals.get(i).start < end && intervals.get(i).end <= end)
                continue;

            else if(intervals.get(i).start <= end && intervals.get(i).end > end)
                end = intervals.get(i).end;

            else if(intervals.get(i).start > end){
                intervalList.add( new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }

        }

        intervalList.add( new Interval(start, end));

        return intervalList;

    }

    /* Using matrix */

    public int[][] mergeUsing2DArray(int[][] intervals) {

        // if the input 2d array has only 1 interval return it
        if(intervals.length<=1)
            return intervals;

        // sort all the intervals(arrays of start time(index 0) and end time(index 1)) by their start time
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return Integer.compare(a1[0], a2[0]); // sorted by index 0(start time)
            }
        });

        // push the first interval in stack, we will compare every other interval with the top interval in the stack and then decide what's to be done
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for(int i=1;i<intervals.length;i++)
        {
            // if next interval's start time is less than the current interval's finish time then merge the intervals
            if(intervals[i][0] <= stack.peek()[1])
            {
                int[] popped = stack.pop();
                popped[1] = Math.max(intervals[i][1], popped[1]); // select the finish time that's bigger amongst both intervals
                stack.push(popped);
            }
            else
                stack.push(intervals[i]); // push if next interval's start time is bigger than previous's finish time
        }

        // the output that we obtain will be in reverse order, so use another stack to straighten it
        Stack<int[]> reverseOutputStack = new Stack<>();
        while(!stack.empty())
        {
            int[] popped = stack.pop();
            reverseOutputStack.push(popped);
        }

        int[][] output = new int[reverseOutputStack.size()][reverseOutputStack.peek().length];

        // Create an output 2d array and add the new stack contents to it and return
        while(!reverseOutputStack.empty())
        {
            for(int i=0;i<output.length;i++)
                output[i] = reverseOutputStack.pop();
        }

        return output;
    }
}
