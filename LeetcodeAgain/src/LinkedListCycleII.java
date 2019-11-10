public class LinkedListCycleII {
     class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
    /* Once you detect a cycle using slow and fast pointers, you can get the start index of the cycle by traversing from the point
    where you found the cycle and from the start of the list. The point they reach is nothing but the start index i.e our answer */
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
            {
                slow = head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
