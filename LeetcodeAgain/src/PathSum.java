public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        int subtracted_sum = sum - root.val;

        if(root.left == null && root.right == null)
        {
            if(subtracted_sum==0)
                return true;
            return false;
        }

        else if(root.left!=null && root.right ==null)
        {
            return hasPathSum(root.left, subtracted_sum);
        }

        else if(root.left == null && root.right!=null)
        {
            return hasPathSum(root.right, subtracted_sum);
        }
        else
        {
            boolean left = hasPathSum(root.left, subtracted_sum);
            boolean right = hasPathSum(root.right, subtracted_sum);
            if(left==true || right==true)
                return true;
            return false;
        }

    }

    /* Optimized */

    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root==null)
            return false;
        int subtracted = sum - root.val;
        if(subtracted==0 && root.left==null && root.right==null)
            return true;
        else
        {
            if(hasPathSum2(root.left, subtracted)||hasPathSum2(root.right, subtracted))
                return true;
        }
        return false;
    }
}
