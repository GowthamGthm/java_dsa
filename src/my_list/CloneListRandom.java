package my_list;

import java.util.HashMap;
import java.util.Map;


public class CloneListRandom {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Node head1 = new Node(head.val, null, null);
        Map<Node, Node> mymap= new HashMap<Node,Node>();
        Node cur= head, cur1 = head1;
        mymap.put(head, head1);
        while(cur.next != null){
            cur1.next = new Node(cur.val, null, null);
            mymap.put(cur.next, cur.next);
            cur = cur.next;
            cur1 = cur1.next;
        }
        cur = head;
        cur1 = head1;
        while(cur != null){
            cur1.random = mymap.get(cur.random);
            cur = cur.next;
            cur1 = cur1.next;
        }

        return head1;
    }
}
