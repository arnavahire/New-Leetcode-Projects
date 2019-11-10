public class CountCompleteTreeNodes {
    /* First check if the tree is perfectly balanced tree(you can find this if height of left subtree of root equals right subtree, if yes, directy return count as 2^h -1), else calculate the nodes recursively */
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        int hLeft = 0;
        int hRight = 0;
        TreeNode pLeft = root, pRight = root;
        // this will also be calculated recursively for shorter subtrees if they are perfectly balanced,so that we can directly return the result and not calulcate nodes recursively
        while(pLeft!=null)
        {
            ++hLeft;
            pLeft=pLeft.left;
        }

        while(pRight!=null)
        {
            ++hRight;
            pRight=pRight.right;
        }

        if(hLeft==hRight)
            return (int) (Math.pow(2, hLeft) -1);

        else
            return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
