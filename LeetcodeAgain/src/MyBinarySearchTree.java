import java.util.Stack;

public class MyBinarySearchTree {

    TreeNode root;

    public MyBinarySearchTree(){
        root = null;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data)
        {
            this.val = data;
            this.left = this.right = null;
        }
    }

    /* Iterative insert into BST */
    public void insert(int data){
        if(root==null)
            root = new TreeNode(data);
        else
        {
            TreeNode temp = root;
            while(true)
            {
                if(data <= temp.val)
                {
                    if(temp.left==null)
                    {
                        temp.left = new TreeNode(data);
                        break;
                    }
                    temp = temp.left;
                }
                else
                {
                    if(temp.right==null)
                    {
                        temp.right = new TreeNode(data);
                        break;
                    }
                    temp = temp.right;
                }
            }
        }
    }

    public TreeNode recursiveInsert(TreeNode root, int data)
    {
        if(root==null)
        {
            root = new TreeNode(data);
            return root;
        }
        else
        {
            if(data <= root.val)
                root.left = recursiveInsert(root.left, data);
            else
                root.right = recursiveInsert(root.right, data);
        }
        return root;
    }

    public void display(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(true)
        {
            if(root!=null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                if(!stack.empty())
                {
                    root = stack.pop();
                    System.out.println(root.val + " ");
                    root = root.right;
                }
                else
                    break;
            }
        }
    }

    /* Iterative Search */
    public int search(int data)
    {
        if(root == null)
            return -1;
        else
        {
            TreeNode temp = root;
            while(true)
            {
                if(data == temp.val)
                    return data;
                if(data < temp.val)
                {
                    if(temp.left==null)
                        return -1;
                    temp = temp.left;
                }
                else
                {
                    if(temp.right==null)
                        return -1;
                    temp = temp.right;
                }
            }
        }
    }

    public TreeNode delete(TreeNode root, int data)
    {
        if(root==null)
            return null;

        else if(data < root.val)
            root.left = delete(root.left, data);

        else if(data > root.val)
            root.right = delete(root.right, data);

        else   // when data matches thr root's val
        {
            if(root.left==null && root.right==null) // case 1 : leaf node
            {
                root = null;
            }
            else if(root.left==null)  // case 2: left node empty
            {
                root = root.right;
            }
            else if(root.right==null)  // case 3: right node empty
            {
                root = root.left;
            }
            else                      // case 4: root has both left and right
            {
                TreeNode temp = findMin(root.right); // find the minimum element in the right subtree and replace root's value with that value
                root.val = temp.val;
                root.right = delete(root.right, temp.val); // delete the minimum node in right subtree after we have used it's val
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode root) // find the minimum in the right subtree. Thi will be obtained by traversing left untill left is not null
    {
        while(true)
        {
            if(root.left==null)
                return root;
            root = root.left;
        }
    }


    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
//        int[] BSTInput= {8, 3, 1, 6, 4, 7, 10, 14, 13};
//
//        for(int i=0;i < BSTInput.length;i++)
//        {
//            bst.insert(BSTInput[i]);
//        }
        bst.root = bst.recursiveInsert(bst.root, 8);
        bst.root = bst.recursiveInsert(bst.root, 3);
        bst.root = bst.recursiveInsert(bst.root, 1);
        bst.root = bst.recursiveInsert(bst.root, 6);
        bst.root = bst.recursiveInsert(bst.root, 4);
        bst.root = bst.recursiveInsert(bst.root, 7);
        bst.root = bst.recursiveInsert(bst.root, 10);
        bst.root = bst.recursiveInsert(bst.root, 14);
        bst.root = bst.recursiveInsert(bst.root, 13);

//        bst.display(bst.root);
//
//        System.out.println(bst.search(2));
//        System.out.println(bst.search(1));
//        System.out.println(bst.search(13));
//        System.out.println(bst.search(7));

        bst.delete(bst.root, 3);
        bst.display(bst.root);
    }
}
