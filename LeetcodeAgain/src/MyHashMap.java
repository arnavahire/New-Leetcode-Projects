public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;
    }

    Node[] bucket;

    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket = new Node[16];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = Integer.hashCode(key) % bucket.length;
        if(bucket[index]==null)
        {
            bucket[index] = new Node();
            bucket[index].key = key;
            bucket[index].value = value;
        }
        else
        {
            Node head = bucket[index];
            while(head!=null)
            {
                if(head.key==key)
                {
                    head.value = value;
                    return;
                }
                if(head.next==null)
                {
                    head.next = new Node();
                    head.next.key = key;
                    head.next.value = value;
                    return;
                }
                else
                    head = head.next;
            }
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) % bucket.length;
        if(bucket[index]==null)
            return -1;
        else
        {
            Node head = bucket[index];
            while(head!=null)
            {
                if(head.key==key)
                    return head.value;
                head=head.next;
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % bucket.length;

        if(bucket[index]==null)
            return;
        else
        {
            Node head = bucket[index];   // the base case when the key to be removed is at 1st index, remove it and set the next as current
            if(head.key==key)
            {
                bucket[index] = bucket[index].next;
                return;
            }
            Node current = head;
            while(current!=null)
            {
                Node next=current.next;
                if(next!=null)
                {
                    if(next.key==key)
                    {
                        current.next = current.next.next; // for deleting we will require predecessor since we can delete a node by editing the Node's 'next' field
                        return;
                    }

                }
                current=current.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}


/*
* import java.io.*;
import java.util.*;


 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


class Solution {

    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class HashTable {
        static Node[] array;

        public HashTable(int count) {
            array = new Node[count];
        }

        public static int getIndex(int key) {
            return Integer.hashCode(key) % array.length;
        }

        public static void put(int key, int val) {
            int index = getIndex(key);
            if(array[index] == null) {
                array[index] = new Node(key, val);
            } else {
                Node current = array[index];
                while(current != null) {
                    if(current.key == key) {
                        current.val = val;
                        return;
                    }
                    if(current.next == null) {
                        current.next = new Node(key, val);
                        return;
                    }
                    current = current.next;
                }
            }
        }

        public static int get(int key) {
            int index = getIndex(key);
            if(array[index] == null) return -1;
            Node current = array[index];
            while(current != null) {
                if(current.key == key) return current.val;
                current = current.next;
            }
            return -1;
        }


        public static void remove(int key) {
            int index = getIndex(key);
            if(array[index] == null) return;
            Node current = array[index];
            if(current.key == key) {
                array[index] = array[index].next;
            }
            while(current != null) {
                Node next = current.next;
                if(next != null) {
                    if(next.key == key) {
                        current.next = current.next.next;
                    }
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        new HashTable(1);
        HashTable.put(1, 10);
        HashTable.put(2, 20);
        System.out.println(HashTable.get(1));
        System.out.println(HashTable.get(2));
        HashTable.remove(2);
        System.out.println(HashTable.get(1));
        System.out.println(HashTable.get(2));
        HashTable.put(2, 20);
        HashTable.put(2, 30);
        System.out.println(HashTable.get(2));
        HashTable.remove(2);
        HashTable.remove(2);
        HashTable.remove(1);
        System.out.println(HashTable.get(1));
        System.out.println(HashTable.get(2));

    }
}
*/