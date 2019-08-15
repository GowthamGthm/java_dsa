package my_queue;
import java.util.PriorityQueue;
import java.util.Stack;

public class Queue_using_stack {
        Stack<Integer>s1;
        Stack<Integer>s2;

        public Queue_using_stack() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();

        }

        public void add(int ele){
            s1.push(ele);

        }
        public int poll(){
            if(s1.isEmpty() == false){
                while(s1.isEmpty() == false){
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
            else {
                return s2.pop();
            }

        }

    public static void main(String args[]){
        Queue_using_stack qs= new Queue_using_stack();
        qs.add(100);
        qs.add(200);
        qs.add(300);
        qs.add(400);

        System.out.println(qs.poll());
        System.out.println(qs.poll());
        System.out.println(qs.poll());
        System.out.println(qs.poll());

    }
}
