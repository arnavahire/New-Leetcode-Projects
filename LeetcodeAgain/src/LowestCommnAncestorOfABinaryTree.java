/*Problem Statement:
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the
lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

*/


/* Solution:
You need to check following cases:
1. if root is null return null
2. if root value equals p's value or q's value return root
3. Find left and right nodes of root.
    i> if both left and right nodes are null, return null
    ii> if both left and right nodes are not null, return root since root will be the least common ancestor
    iii> if either left is not null return left's value recursively upto the root of tree, else return right's value
    recursively upto the root of tree

*/
public class LowestCommnAncestorOfABinaryTree {

    TreeNode root;

    /* My crude solution */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;

        if((root.val == p.val) || (root.val == q.val))
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if((left == null) && (right == null))
            return null;

        if((left != null) && (right != null))
            return root;

        return (left != null) ? left : right;
    }


    public static void main(String[] args) {
        LowestCommnAncestorOfABinaryTree tree = new LowestCommnAncestorOfABinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(6);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(11);
        tree.root.left.right.left = new TreeNode(9);
        tree.root.left.right.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(13);
        tree.root.right.right.left = new TreeNode(7);

        TreeNode p = new TreeNode(8);
        TreeNode q = new TreeNode(7);

        System.out.println("LCA: "+tree.lowestCommonAncestor(tree.root, p, q).val);
    }
}
