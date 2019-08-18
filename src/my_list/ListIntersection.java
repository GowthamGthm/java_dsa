package my_list;

public class ListIntersection {

     // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int len1=0, len2=0;
         ListNode first = headA;
         ListNode second = headB;

         if(headA == null || headB == null)
             return null;

         while(first != null){
             len1++;
             first = first.next;
         }
         while(second != null){
             len2++;
             second = second.next;
         }
         first = headA;
         second = headB;

         while(len1 > len2){
             len1--;
             first = first.next;

         }
         while(len2 > len1){
             len2--;
             second = second.next;
         }
         while(first != null && second != null){
             if (first == second)
                 return first;
             first = first.next;
             second = second.next;
         }
         return null;
    }
}
