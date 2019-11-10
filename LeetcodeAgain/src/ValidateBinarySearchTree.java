public class ValidateBinarySearchTree {

    /* Don't compare root's val with its left or right, cause you maay not get a bst. Instead use range of values for children. Set upper bound for left and lower bound for right */

    public boolean isValidBST(TreeNode root) {
        // using Long.MIN_VALUE and max value cause for some reason one of the test cases is not accepting int
        Long min = Long.MIN_VALUE;
        Long max = Long.MAX_VALUE;

        return isBST(root, min, max);
    }

    public boolean isBST(TreeNode root, long min, long max)
    {
        if(root == null){
            return true;
        }
        // if the root's val is lesss than min or greater than max return false
        if(root.val <= min || root.val >= max){
            return false;
        }
        // for left, set the upper bound as the root val, for right set the lower bound as root val
        else return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}
