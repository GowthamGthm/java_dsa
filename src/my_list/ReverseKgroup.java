package my_list;

public class ReverseKgroup {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head){
        ListNode prev=null, cur=head, next=null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null, cur=null, knext=null, khead=null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        prev = cur = dummy;
        khead = dummy.next;
        int i = 0;
        while(cur.next != null){
            cur = cur.next;
            i++;
            if(i == k){
                knext = cur.next;
                cur.next = null;
                prev.next = reverseList(khead);
                khead.next = knext;
                prev =cur = khead ;
                khead = knext;
                i = 0;
            }
        }
        return dummy.next;

    }
}
