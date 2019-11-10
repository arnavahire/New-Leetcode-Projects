class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeTraversalsNoStack {

    TreeNode root;

    public BinaryTreeTraversalsNoStack(){
        root = null;
    }

    public void inorderTraversal(TreeNode node){
        if(node==null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.val+" ");
        inorderTraversal(node.right);
    }

    public void preorderTraversal(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void postorderTraversal(TreeNode node){
        if(node==null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val+" ");
    }

    public static void main(String[] args) {
        BinaryTreeTraversalsNoStack tree = new BinaryTreeTraversalsNoStack();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("Inorder traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println();
        System.out.println("Preorder traversal:");
        tree.preorderTraversal(tree.root);
        System.out.println();
        System.out.println("Postorder traversal:");
        tree.postorderTraversal(tree.root);
    }
}
