package my_queue;

import java.util.LinkedList;
import java.util.Queue;

public class myqueue1 {
    int capacity;
    int arr[];
    int size;
    int front;
    int rear;
    class QueueEmptyException extends Exception{
        QueueEmptyException(String msg){
            super(msg);
        }
    }
    public myqueue1(int sz){
        capacity = sz;
        arr = new int[sz];
        size = 0;
        front = 0;
        rear = -1;
    }
//add
    public void add(int ele){
        if (size() == capacity){
            System.out.println("Queue is Full!!!!");
            return;
        }
        size++;
        rear = (rear + 1) % capacity;
        arr[rear] = ele;

    }
//poll
    public int poll() throws QueueEmptyException{
        if(size() == 0){
            System.out.println("Queue is Empty!!!!");
//            throw new QueueEmptyException("Queue is Empty")
            return -1;
        }
        size--;
        int ele = arr[front];
//        System.out.println("Element to be popped is " + ele );
        front = (front + 1) % capacity;
        return ele;
    }

    public int peek(){
        if(size() == 0){
            System.out.println("Queue is Empty!!!!");
//            throw new QueueEmptyException("Queue is Empty")
            return -1;
        }
        return arr[front];
    }
//    How many elements are present in the queue
    public int size(){
        return size;
    }
    public Boolean isEmpty(){
        if (size == 0)
            return true;
        return false;
    }
    public Boolean isFull(){
        if (size == capacity)
            return true;
        return false;
    }
    public Boolean has(int ele){
        return true;
    }

    public static void main(String args[]) throws QueueEmptyException{
        myqueue1 q = new myqueue1(5);
        Queue<Integer> q2 = new LinkedList<Integer>();
        q2.add(3000);
        q2.add(4000);
        q2.add(5000);
        q2.add(6000);
        q2.add(7000);
        System.out.println(q2.peek());
//        System.out.println(q2.poll());
//        System.out.println(q2.peek());
//        System.out.println(q2.isEmpty());
//        System.out.println(q2.poll());
//        System.out.println(q2.poll());
//        System.out.println(q2.poll());
//        System.out.println(q2.poll());
//        System.out.println(q2.isEmpty());
//        System.out.println(q2.poll());
//        System.out.println(q2.poll());
//        System.out.println(q2.poll());


//        q.add(100);
//        q.add(200);
//        q.add(300);
//        q.add(400);
//        q.poll();
//        q.add(500);
//
//        q.enQueue(1000);
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());


    }
}
