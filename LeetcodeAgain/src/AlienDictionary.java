import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>(); // it will store the adjacency list for each vertex
        Map<Character, Integer> inDegreeMap = new HashMap<>(); // it will store the indegree count for every vertex
        Queue<Character> queue = new LinkedList<>(); // all the vertices whose indegrees are 0 will be added to the queue and removed one by one


        // 1. We traverse all the characters in all the words and create the graph for every unique character(vertex)
        // with empty set and set indegree to 0
        for(String word : words)
        {
            for(char c : word.toCharArray())
            {
                    graph.put(c, new HashSet<>());
                    inDegreeMap.put(c, 0);
            }
        }

        // 2. We compare characters at same index between 2 words, if the character matches, we just move ahead,
        // if it doesn't match we add an edge and make entry of next character in adjacency list(in this case Set) of current word
        // and increment the indegree of next character by 1
        for(int i=0;i<words.length-1;i++)
        {
            int index=0;
            char[] current = words[i].toCharArray();
            char[] next = words[i+1].toCharArray();

            int compareLen = Math.min(current.length, next.length); // we will iterate over the string of lowest length amongst 2 words

            while(index < compareLen)
            {
                char curr = current[index];
                char nxt = next[index];
                if(curr == nxt)
                    index++;
                else
                {
                    if(!graph.get(curr).contains(nxt)) // if the vertex is not present in adjacency list we add it and increase its indegree
                    {
                        graph.get(curr).add(nxt);
                        inDegreeMap.put(nxt, inDegreeMap.get(nxt)+1);
                    }
                    break;
                }
            }
        }

        for(char key : inDegreeMap.keySet())  // 3. We choose the elements with indegree 0 and add them to the queue
        {
            if(inDegreeMap.get(key)==0)
                queue.add(key);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) // 4. while queue is not empty, remove front element and add it to final string and then reduce the indegree of each vertex in adjacency list by 1 tll we get final string
        {
            char c = queue.poll();
            sb.append(c);

            for(char value : graph.get(c))
            {
                inDegreeMap.put(value, inDegreeMap.get(value)-1);
                if(inDegreeMap.get(value)==0)
                    queue.add(value);
            }
        }

        // 5. if the indegree of all vertices doesn't become 0 that means cycle exists, hence we will return empty string
        for(char key : inDegreeMap.keySet())
        {
            if(inDegreeMap.get(key) != 0)
                return "";
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words = {
                "za","zb","ca","cb"};
        System.out.println(ad.alienOrder(words));
    }
}
