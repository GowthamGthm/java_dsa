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

        }

        public int deleteFirst(){
            return 0;
        }

        public int deleteLast(){
            return 0;
        }

        public boolean search(int key){
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
        ml.insertFirst(10);
        ml.insertFirst(20);
        ml.insertFirst(30);
        ml.insertFirst(40);
        ml.insertFirst(50);
        ml.print();

    }

}
