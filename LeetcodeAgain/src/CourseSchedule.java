import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for(int i=0;i<numCourses;i++)
        {
            graph.put(i,new HashSet<>());
            inDegree.put(i, 0);
        }

        for(int i=0;i<prerequisites.length;i++)
        {
            int j=0;

            inDegree.put(prerequisites[i][j], inDegree.get(prerequisites[i][j])+1);
            graph.get(prerequisites[i][j+1]).add(prerequisites[i][j]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(Integer key :inDegree.keySet())
        {
            if(inDegree.get(key)==0)
                queue.add(key);
        }

        while(!queue.isEmpty())
        {
            int frontElement =  queue.poll();
            count++;

            for(int p : graph.get(frontElement))
            {
                inDegree.put(p, inDegree.get(p)-1);
                if(inDegree.get(p)==0)
                    queue.add(p);
            }
        }

        for(int key: inDegree.keySet())
            if(inDegree.get(key)!=0)
                return false;

        return true;

    }
}
