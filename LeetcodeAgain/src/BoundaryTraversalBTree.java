import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalBTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    List<Integer> result = new ArrayList<>();
    Node root;

    public void printLeftBoundary(Node root){
        if(root==null)
            return;

        // If left child exists then you visit only left child and not right child since you want the left boundary.
        // however left child does not exist then right child is traversed to get the left boundary.
        // Hence the use of IF and ELSE IF
        if(root.left!=null){
            result.add(root.data);
            printLeftBoundary(root.left);
        }

        else if(root.right!=null){
            result.add(root.data);
            printLeftBoundary(root.right);
        }
    }

    // Similarly right subtree, but here we will be printing from down to up, so we will traverse first and then print later
    public void printRightBoundary(Node root){
        if(root==null)
            return;

        if(root.right!=null)
        {
            printRightBoundary(root.right);
            result.add(root.data);
        }

        else if(root.left!=null)
        {
            printRightBoundary(root.left);
            result.add(root.data);
        }
    }

    public void printLeaves(Node root){
        if(root==null)
            return;

        printLeaves(root.left);

        if(root.left==null && root.right == null)
            result.add(root.data);

        printLeaves(root.right);
    }

    public void printBoundary(Node root)
    {
        if(root==null)
            return;

        result.add(root.data);  // first add root to answer if root isn't null

        printLeftBoundary(root.left);  // calculate left boundary on left subtree

        printLeaves(root.left);       // print leaves on left and right subtree
        printLeaves(root.right);

        printRightBoundary(root.right);  // calculate right boundary on right subtree
    }

    public static void main(String args[])
    {
        BoundaryTraversalBTree tree = new BoundaryTraversalBTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }
}
