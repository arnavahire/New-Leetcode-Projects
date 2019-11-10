import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    int top;
    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public StackUsingQueue() {
        top=-1;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            int popped = q1.remove();
            q2.add(popped);
        }

        int returnValue = q1.remove();

        Queue<Integer> temp=q1;
        q1=q2;
        q2= temp;
        return returnValue;
    }

    /** Get the top element. */
    public int top() {
        while(q1.size()>=1){
            if(q1.size()==1)
            {
                top = q1.remove();
                q2.add(top);
            }
            else
            {
                q2.add(q1.remove());
            }
        }
        Queue<Integer> temp=q1;
        q1=q2;
        q2= temp;
        return top;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */