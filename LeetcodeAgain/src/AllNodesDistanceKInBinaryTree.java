import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    Map<TreeNode , TreeNode> parent = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        dfs(root, null);

        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int dist=0;

        // order of insertion is important in queue because we are using null to differentiate between distance levels
        queue.add(null);
        queue.add(target);

        seen.add(null);
        seen.add(target);

        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();

            if(node==null)
            {
                if(dist==K)
                {
                    List<Integer> res = new ArrayList<>();
                    for(TreeNode n : queue)
                        res.add(n.val);
                    return res;
                }
                queue.offer(null);
                dist++;
            }
            else
            {
                if(!seen.contains(node.left))
                {
                    seen.add(node.left);
                    queue.add(node.left);
                }
                if(!seen.contains(node.right))
                {
                    seen.add(node.right);
                    queue.add(node.right);
                }

                TreeNode par = parent.get(node);

                if(!seen.contains(par))
                {
                    seen.add(par);
                    queue.add(par);
                }
            }
        }
        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par)
    {
        if(node!=null)
        {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}