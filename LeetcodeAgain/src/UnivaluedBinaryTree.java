import java.util.LinkedList;
import java.util.Queue;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int val = root.val;

        while(!queue.isEmpty())
        {
            TreeNode removed = queue.poll();
            if(removed.val!= val)
                return false;

            if(removed.left!=null)
                queue.add(removed.left);

            if(removed.right!=null)
                queue.add(removed.right);
        }
        return true;

    }
}
