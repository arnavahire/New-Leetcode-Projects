import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversalUsingStack {
    TreeNode root;

    public List<Integer> inorderTraversal(TreeNode root){
        LinkedList<Integer> traversalList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(true)
        {
            if(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            else{
                if(!stack.isEmpty())
                {
                    root = stack.pop();
                    traversalList.add(root.val);
                    root=root.right;
                }
                else
                    break;    // stack is empty so traversal is complete. Hence break the loop
            }
        }
        return traversalList;
    }

    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<Integer> traversalList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null)
            return traversalList;

        stack.push(root);

        while(!stack.isEmpty()){
            traversalList.add(stack.peek().val);
            root = stack.pop();

            if(root.right!=null)
                stack.push(root.right);

            if(root.left!=null)
                stack.push(root.left);
        }

        return traversalList;
    }

    public static void main(String[] args) {
        BinaryTreeTraversalUsingStack tree = new BinaryTreeTraversalUsingStack();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("Inorder traversal:");
        List<Integer> list = tree.inorderTraversal(tree.root);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("Preorder traversal:");
        list = tree.preorderTraversal(tree.root);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        /*System.out.println();
        System.out.println("Postorder traversal:");
        tree.postorderTraversal(tree.root);*/
    }
}
