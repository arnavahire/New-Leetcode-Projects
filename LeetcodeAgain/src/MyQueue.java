import java.util.Stack;

public class MyQueue {
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

    Node rear;
    Node front;

    public MyQueue()
    {
        this.rear = null;
        this.front = null;
    }

    public boolean isEmpty()
    {
        if(this.rear==null & this.front==null)
            return true;
        return false;
    }

    public void enqueue(int data)
    {
        Node newNode = new Node();
        newNode.setData(data);
        if(isEmpty())
        {
            this.front = this.rear = newNode;
            newNode.next = null;
        }
        newNode.next = rear;
        rear = newNode;
    }

    public int dequeue()
    {
        int data;
        if(isEmpty() || this.front==null)
        {
            this.rear = null;
            System.out.println("Cannot dequeue. Queue is empty");
            System.exit(0);
        }
        if(this.rear == this.front)
        {
            data = this.front.getData();
            this.front = this.rear = null;

        }
        else
        {
            Node temp = this.rear;
            while (temp.next!=this.front)
            {
                temp = temp.next;
            }
            data = this.front.getData();
            temp.next = null;
            this.front = temp;
        }
        return data;
    }

    public int peek()
    {
        if(isEmpty() || this.front == null)
        {
            System.out.println("Empty queue");
            System.exit(0);
        }

        return this.front.getData();
    }

    public void display()
    {
        if(isEmpty() || this.front==null)
        {
            System.out.println("Nothing to display. Queue is empty");
            System.exit(0);
        }
        else
        {
            Node temp = this.rear;
            Stack<Integer> stack = new Stack<>();
            while(temp!=null)
            {
                stack.add(temp.data);
                temp = temp.next;
            }
            while(!stack.empty())
            {
                System.out.println("Element: "+stack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        System.out.println("Current peek element: "+q.peek());
        q.enqueue(50);

    }


}
