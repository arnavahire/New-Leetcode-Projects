import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    TreeNode root;

    public List<List<Integer>> levelorderTraversal(TreeNode root){
        List<List<Integer>> listOfLevels = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return listOfLevels;

        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> levelElements = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                root = queue.poll();
                levelElements.add(root.val);

                if(root.left!=null)
                    queue.add(root.left);

                if(root.right!=null)
                    queue.add(root.right);
            }

            listOfLevels.add(levelElements);
        }
        return listOfLevels;
    }

    /* 107. Binary Tree level order traversal II
    Problem statement: Given a binary tree, return the bottom-up level order traversal of its nodes' values.
    (ie, from left to right, level by level from leaf to root).*/

    // Approach 1: Use a stack at the end

    public List<List<Integer>> levelorderTraversal2(TreeNode root){
        List<List<Integer>> listOfLevelsBottomup = new ArrayList<List<Integer>>();
        Stack<List<Integer>> listOfLevels = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return listOfLevels;

        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> levelElements = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                root = queue.poll();
                levelElements.add(root.val);

                if(root.left!=null)
                    queue.add(root.left);

                if(root.right!=null)
                    queue.add(root.right);
            }

            listOfLevels.add(levelElements);
        }

        while (!listOfLevels.isEmpty())
            listOfLevelsBottomup.add(listOfLevels.pop());

        return listOfLevelsBottomup;
    }

    // Approach 2: Use a java util's Collections.reverse

    public List<List<Integer>> levelorderTraversalII(TreeNode root){
        List<List<Integer>> listOfLevels = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
            return listOfLevels;

        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> levelElements = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                root = queue.poll();
                levelElements.add(root.val);

                if(root.left!=null)
                    queue.add(root.left);

                if(root.right!=null)
                    queue.add(root.right);
            }

            listOfLevels.add(levelElements);
        }

        Collections.reverse(listOfLevels);

        return listOfLevels;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal tree = new BinaryTreeLevelOrderTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("Level order traversal:");
        List<List<Integer>> traversalList = tree.levelorderTraversal(tree.root);
        for(int i=0;i<traversalList.size();i++){
            System.out.print(traversalList.get(i)+" ");
        }
        System.out.println();

        System.out.println("Level order traversal 2: Using stack");
        traversalList = tree.levelorderTraversal2(tree.root);
        for(int i=0;i<traversalList.size();i++){
            System.out.print(traversalList.get(i)+" ");
        }
        System.out.println();

        System.out.println("Level order traversal II: Using collections.reverse");
        traversalList = tree.levelorderTraversal2(tree.root);
        for(int i=0;i<traversalList.size();i++){
            System.out.print(traversalList.get(i)+" ");
        }

        /* See traversal 1 by 1
        for(int i=0;i<traversalList.size();i++){
            for(int j=0;j<traversalList.get(i).size();j++)
                System.out.print(traversalList.get(i).get(j)+" ");
        }*/
    }
}
