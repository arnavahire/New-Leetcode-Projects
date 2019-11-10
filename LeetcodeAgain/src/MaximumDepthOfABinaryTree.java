import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfABinaryTree {
    TreeNode root;

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth=0;

        if(root==null)
            return maxDepth;

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode dequeued = queue.poll();

                if(dequeued.left!=null)
                    queue.add(dequeued.left);

                if(dequeued.right!=null)
                    queue.add(dequeued.right);

            }
            maxDepth++;
        }
        return maxDepth;
    }

    /* Recursive solution */
    public int maxDepthRecursive(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfABinaryTree tree = new MaximumDepthOfABinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(6);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(11);
        tree.root.left.right.left = new TreeNode(9);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(13);
        tree.root.right.right.left = new TreeNode(7);
        System.out.println("Maximum  depth of the binary tree is: "+tree.maxDepth(tree.root));
    }
}
