class Node
{
    private int data;
    Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
public class MyStack {
    Node top;

    public MyStack(){
        this.top=null;
    }

    public void push(int data)
    {
        if(isEmpty())
        {
            Node newNode = new Node();
            newNode.setData(data);
            newNode.next = null;
            top = newNode;
        }
        else
        {
            Node newNode = new Node();
            newNode.setData(data);
            newNode.next = top;
            top = newNode;
        }

    }

    public int pop()
    {
        int data;
        if(isEmpty())
        {
            System.out.println("Stack is empty. Can not perform pop operation");
            System.exit(0);
        }
        if(top.next==null)
        {
            data = top.getData();
            top = null;
        }
        else
        {
            data = top.getData();
            top = top.next;
        }
        return data;
    }

    public boolean isEmpty()
    {
        if(top==null)
            return true;
        return false;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty. Can not perform pop operation");
            System.exit(0);
        }
        return top.getData();
    }

    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty. Can not perform pop operation");
            System.exit(0);
        }
        Node temp = top;
        while(temp!=null)
        {
            System.out.println("Element: "+ temp.getData());
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(11);
        stack.push(22);
        stack.push(33);

        System.out.println(stack.peek());
        stack.push(44);

        int data = stack.pop();
        System.out.println("Popped element: " + data);

        stack.display();

        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();


    }
}
