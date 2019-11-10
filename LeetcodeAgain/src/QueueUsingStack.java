import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enQueue(int x)
    {
        s1.push(x);
    }

    public int deQueue()
    {
        if(empty())
        {
            return -1;
        }
        while(!s1.isEmpty())
        {
            s2.add(s1.pop());
        }
        int returnValue = -1;
        if(!s2.isEmpty())
             returnValue = s2.pop();

        while(!s2.isEmpty())
            s1.add(s2.pop());

        return returnValue;
    }

    public int peek()
    {
        if(empty())
        {
            return -1;
        }
        while(!s1.isEmpty())
        {
            s2.add(s1.pop());
        }

        int returnValue = s2.peek();

        while(!s2.isEmpty())
            s1.add(s2.pop());
        return returnValue;
    }

    public boolean empty(){
        if(s1.isEmpty())
            return true;
        return false;
    }



}
