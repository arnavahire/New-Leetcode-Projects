import java.util.Hashtable;
public class LRUCache {
        class DoublyLinkedNode {
            int key;
            int value;
            DoublyLinkedNode prev;
            DoublyLinkedNode next;
        }

        Hashtable<Integer,DoublyLinkedNode> myCache=new Hashtable<Integer, DoublyLinkedNode>();
        int count;
        int capacity;
        DoublyLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.count = 0;

            head = new DoublyLinkedNode();
            tail = new DoublyLinkedNode();

            head.prev = null;
            head.next = tail;

            tail.prev = head;
            tail.next = null;

        }

        public void addNodeToHead(DoublyLinkedNode node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public DoublyLinkedNode removeNode(DoublyLinkedNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        public DoublyLinkedNode removeFromTail(){
            return removeNode(tail.prev);
        }

        public void moveNodeToHead(DoublyLinkedNode node){
            DoublyLinkedNode nodeToMove = removeNode(node);
            addNodeToHead(nodeToMove);
        }

        public int get(int key) {
            if(myCache.containsKey(key))
            {
                DoublyLinkedNode node = myCache.get(key);
                moveNodeToHead(node);
                return node.value;
            }
            else
                return -1;
        }

        public void put(int key, int value) {

            DoublyLinkedNode node = myCache.get(key);

            if(node == null)
            {
                DoublyLinkedNode newNode = new DoublyLinkedNode();
                newNode.key = key;
                newNode.value = value;

                myCache.put(key, newNode);
                addNodeToHead(newNode);

                count++;

                if(count > capacity){
                    DoublyLinkedNode removedNode = removeFromTail();
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
