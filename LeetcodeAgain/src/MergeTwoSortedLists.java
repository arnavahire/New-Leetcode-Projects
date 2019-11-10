public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;

        if(l2==null)
            return l1;

        ListNode l3 = null;

        if(l1.val<=l2.val)
        {
            l3 = l1;
            l3.next = mergeTwoLists(l1.next, l2);
        }

        else if(l2.val < l1.val)
        {
            l3 = l2;
            l3.next = mergeTwoLists(l1, l2.next);
        }
        return l3;
    }
}
