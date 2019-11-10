import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // here since the number of courses can be any number and prereqs can be 0 to n-1 or even 0,
        // we will always create graph for all the courses and hence we will use numCourses to popoulate data.
        //Ex: if numCourses = 3 and prereq =[], your answer should be [0,1,2] which is not possible if  you use prereqs to make your graph since you do not have enough information
        // of all courses

         /*NOTE: Use numCourses to Make your graph for above reason. DO NT USE prereqs*/

         /* This one is not similar to alien dictionary because in alien dictionary we didn't know all the words and so we could order the nes we knew
         But here we do know all the courses by their numbers, hence we will use numCourses to make the graph */
        for(int i=0;i<numCourses;i++)
        {
            graph.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }

        for(int i=0;i<prerequisites.length;i++)
        {
            int j=0;
            inDegree.put(prerequisites[i][j], inDegree.get(prerequisites[i][j])+1);
            graph.get(prerequisites[i][j+1]).add(prerequisites[i][j]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int key : inDegree.keySet())
        {
            if(inDegree.get(key)==0)
                queue.add(key);
        }

        int[] answer = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty())
        {
            int frontElement = queue.poll();
            answer[count] = frontElement;
            count++;

            for(int val : graph.get(frontElement))
            {
                inDegree.put(val, inDegree.get(val)-1);
                if(inDegree.get(val)==0)
                    queue.add(val);
            }
        }

        for(int key : inDegree.keySet()) {
            if (inDegree.get(key) != 0)
                return new int[]{};
        }

        return answer;
    }

    public static void main(String[] args) {
        CourseScheduleII cs2 = new CourseScheduleII();
        int numCourse = 3;
        int[][] ip = {{1,0}};
        int[] res= cs2.findOrder(numCourse, ip);
        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);
    }
}
