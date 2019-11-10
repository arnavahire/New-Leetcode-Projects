
public class AVLTree {

    class Node{
        int data;
        Node left;
        Node right;
        int height;
    }

    public Node insert(Node root, int data)
    {
        if(root==null)
        {
            root=new Node();
            root.data=data;
            return root;
        }
        if(data<=root.data)
            root.left=insert(root.left, data);
        else
            root.right=insert(root.right, data);

        int bal = balance(root.left, root.right);

        if(bal > 1)
        {
            if(height(root.left.left)>=height(root.left.right))
                root=rightRotate(root);
            else
            {
                root.left=leftRotate(root.left);
                root=rightRotate(root);
            }
        }
        else if(bal < -1)
        {
            if(height(root.right.right)>=height(root.right.left))
                root = leftRotate(root);
            else
            {
                root.right=rightRotate(root.right);
                root=leftRotate(root);
            }
        }
        else
            root.height = setHeight(root);
        return root;
    }

    public Node leftRotate(Node root)
    {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }

    public Node rightRotate(Node root)
    {
        Node newRoot = root.left;
        newRoot.right = root.left;
        newRoot.right = root;
        root.height = setHeight(root);
        newRoot.height = setHeight(newRoot);
        return newRoot;
    }

    public int balance(Node left, Node right)
    {
        return(height(left)-height(right));
    }

    public int setHeight(Node root)
    {
        if(root==null) return 0;
        else return 1+ Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }

    public int height(Node root)
    {
        if(root==null) return 0;
        else return root.height;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        Node root=null;
        root = avlTree.insert(root, -10);
        root = avlTree.insert(root, 2);
        root = avlTree.insert(root, 13);
        root = avlTree.insert(root, -13);
        root = avlTree.insert(root, -15);
        root = avlTree.insert(root, 15);
        root = avlTree.insert(root, 17);
        root = avlTree.insert(root, 20);

        avlTree.inorder(root);
    }

    public void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
}
