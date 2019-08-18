package my_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsortedList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, prev=null, cur=null;
        PriorityQueue<ListNode>myq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val )
                    return 1;
                if (o1.val < o2.val)
                    return 2;

                return 0;
            }
        });

        for(int i=0;i<lists.length;i++)
            myq.add(lists[i]);
        if(myq.size() > 0){
            prev = head = myq.poll();
            if(head.next != null) {
                myq.add(head.next);
            }

        }
        while(myq.size() > 0){
            cur = myq.poll();
            prev.next = cur;
            if(cur.next != null)
                myq.add(cur);
            prev = cur;
        }
        return head;
    }
    public static void main(String args[]){
        MergeKsortedList o1 = new MergeKsortedList();

    }

}
