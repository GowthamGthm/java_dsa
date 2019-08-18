package my_list;

public class MySingleList {

    class Node{
        int data;
        Node next;
        public Node(int ele){
            data= ele;
        }
    }

        Node head;

        public void insertFirst(int ele){
            Node tmp = new Node(ele);
            if (head == null)
                head = tmp;
            else{
                tmp.next = head;
                head = tmp;
            }

        }

        public void insertLast(int ele){
            Node tmp = new Node(ele);
            Node cur= null;
            if (head == null)
                head = tmp;
            else {
                cur = head;
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = tmp;
            }


        }

        public Node deleteFirst(){
            Node tmp = head;
            if(head == null || head.next == null)
                return null;

            head = head.next;
            tmp.next = null;

            return head;
        }

        public Node deleteLast(){
            Node cur = head, prev = null;
            if(head == null || head.next == null)
                return null;
            while(cur.next != null){
                prev = cur;
                cur = cur.next;

            }
            prev.next = null;
            return null;
        }

        public boolean search(int key){
            if (head == null)
                return false;
            Node cur = head;
            while (cur != null){
                if(cur.data == key)
                    return true;
                cur = cur.next;
            }

            return false;
        }

        public void insertPos(int ele, int pos){

        }
        public void print(){
            System.out.println("List is:");
            Node cur = head;
            while(cur != null){
                System.out.println(cur.data);
                cur = cur.next;
            }
        }

    public static void main(String args []) {
        MySingleList ml = new MySingleList();
//        ml.insertFirst(10);
//        ml.insertFirst(20);
//        ml.insertFirst(30);
//        ml.insertFirst(40);
//        ml.insertFirst(50);

//        100 -> 1000 ->1900 -> 200 -> 300 -> 400 -> null
        ml.insertLast(100);
        ml.insertLast(1000);
        ml.insertLast(1900);
        ml.insertLast(200);
        ml.insertLast(300);
        ml.insertLast(400);
        System.out.println("Searching 9000 " + ml.search(1900));

        ml.print();

    }

}
