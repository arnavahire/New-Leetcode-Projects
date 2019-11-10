import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagTraversalList = new ArrayList<List<Integer>>();
        if(root==null)
            return zigzagTraversalList;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);
        while(!s1.isEmpty())
        {
            List<Integer> listOfStack1 = new ArrayList<>();
            List<Integer> listOfStack2 = new ArrayList<>();
            while(!s1.isEmpty())
            {
                TreeNode popped = s1.pop();
                listOfStack1.add(popped.val);

                if(popped.left!=null)
                    s2.add(popped.left);
                if(popped.right!=null)
                    s2.add(popped.right);
            }

            while(!s2.isEmpty())
            {
                TreeNode popped = s2.pop();
                listOfStack2.add(popped.val);

                if(popped.right!=null)
                    s1.add(popped.right);
                if(popped.left!=null)
                    s1.add(popped.left);
            }

            if(listOfStack1.size() > 0)
                zigzagTraversalList.add(listOfStack1);
            if(listOfStack2.size() > 0)
                zigzagTraversalList.add(listOfStack2);
        }
        return zigzagTraversalList;

    }
}
