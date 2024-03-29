import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /*Recursive Solution */
    public boolean isSymmetric2(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;
        if(t1.val == t2.val)
        {
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
        return false;
    }

    /* Iterative solution */
    public boolean isSymmetric(TreeNode root) {
        /* Push the root twice, and then queue add left's left and right's right and so on*/
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2 == null)
                continue;

            if(t1==null || t2==null)
                return false;

            if(t1.val != t2.val)
                return false;

            if(t1.val == t2.val)
            {
                queue.add(t1.left);
                queue.add(t2.right);
                queue.add(t1.right);
                queue.add(t2.left);
            }
        }
        return true;
    }
}
