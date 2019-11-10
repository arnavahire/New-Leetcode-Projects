import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class LRUCache3 {

    class DoublyLinkedNode{
        int key;
        int value;
        DoublyLinkedNode prev;
        DoublyLinkedNode next;

        public DoublyLinkedNode(int key, int val){
            this.key=key;
            this.value=val;
        }
    }

    int capacity;
    int count;
    Map<Integer, DoublyLinkedNode> myCache;
    DoublyLinkedNode head;
    DoublyLinkedNode tail;

    public LRUCache3(int capacity) {
        this.capacity=capacity;
        count=0;
        myCache = new HashMap<>();
        head = new DoublyLinkedNode(-1,-1);
        tail = new DoublyLinkedNode(-1,-1);
        head.prev=null;
        head.next=tail;
        tail.prev=head;
        tail.next=null;
    }

    public void addNodeToHead(DoublyLinkedNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev=node;
        head.next = node;
    }

    public DoublyLinkedNode removeNode(DoublyLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public void moveNodeToHead(DoublyLinkedNode node){
        DoublyLinkedNode moveToHead = removeNode(node);
        addNodeToHead(moveToHead);
    }

    public DoublyLinkedNode removeFromTail(){
        DoublyLinkedNode node = tail.prev;
        node.prev.next=tail;
        node.next.prev=node.prev;
        return node;
    }

    public int get(int key) {
        if(myCache.containsKey(key))
        {
            moveNodeToHead(myCache.get(key));
            return myCache.get(key).value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        DoublyLinkedNode node = myCache.get(key);
        if(node==null)
        {
            DoublyLinkedNode entry = new DoublyLinkedNode(key,value);
            addNodeToHead(entry);
            myCache.put(key, entry);
            count++;
            if(count>capacity){
                DoublyLinkedNode removed = removeFromTail();
                myCache.remove(removed.key);
                count--;
            }
        }
        else
        {
            node.value=value;
            moveNodeToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */