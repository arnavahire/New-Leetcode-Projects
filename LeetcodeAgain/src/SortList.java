public class SortList {
     public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next; // fast will be step ahead of slow

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode b = slow.next; // store slow's next in a listnode and make slow.next = null
        slow.next = null;
        ListNode a = head;     // make the head as another node
        a = sortList(a);       // sort both of them
        b = sortList(b);
        return merge(a,b);    // merge both of them
    }

    public ListNode merge(ListNode a, ListNode b)
    {
        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while(a!=null && b!=null)
        {
            if(a.val<=b.val)
            {
                current.next = a;
                a=a.next;
                current = current.next;
            }
            else
            {
                current.next=b;
                b=b.next;
                current = current.next;
            }
        }
        while(a!=null)
        {
            current.next = a;
            a=a.next;
            current=current.next;
        }
        while(b!=null)
        {
            current.next = b;
            b=b.next;
            current=current.next;
        }
        return dummy.next;
    }
}
