import java.util.PriorityQueue;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int i=0;i<lists.length;i++)
        {
            ListNode head = lists[i];
            while(head!=null)
            {
                minHeap.add(head.val);
                head = head.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!minHeap.isEmpty())
        {
            temp.next = new ListNode(minHeap.poll());
            temp = temp.next;
        }

        return dummy.next;
    }
}
