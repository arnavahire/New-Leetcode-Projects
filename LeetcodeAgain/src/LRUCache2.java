import java.util.Hashtable;

public class LRUCache2 {
    class DoublyLinkedNode{
        int key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;
    }

    Hashtable<Integer, DoublyLinkedNode> myCache;
    DoublyLinkedNode head, tail;
    int capacity;
    int count;

    public LRUCache2(int capacity){
        this.capacity=capacity;
        myCache = new Hashtable<>();
        head = new DoublyLinkedNode();
        tail = new DoublyLinkedNode();

        head.prev = null;
        head.next = tail;

        tail.prev = head;
        tail.next = null;

        count=0;
    }

    public void addNodeToHead(DoublyLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public DoublyLinkedNode removeNodeFromTail(){
        DoublyLinkedNode node = tail.prev;
        node.prev.next=tail;
        tail.prev = node.prev;
        return node;

    }
    public void removeNode(DoublyLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void moveNodeToHead(DoublyLinkedNode node){
        removeNode(node);
        addNodeToHead(node);
    }

    public int get(int key)
    {
        if(myCache.containsKey(key))
        {
            DoublyLinkedNode node = myCache.get(key);
            moveNodeToHead(node);
            return node.value;
        }
        else return -1;
    }
    public void put(int key, int value){
        DoublyLinkedNode node = myCache.get(key);
        if(node==null)
        {
            DoublyLinkedNode newNode = new DoublyLinkedNode();
            newNode.key = key;
            newNode.value = value;
            addNodeToHead(newNode);
            myCache.put(key, newNode);
            count++;

            if(count > capacity)
            {
                DoublyLinkedNode removedNode = removeNodeFromTail();
                myCache.remove(removedNode.key);
                count--;
            }
        }
        else
        {
            node.value = value;
            moveNodeToHead(node);
        }

    }

}
