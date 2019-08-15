package my_stack;

public class MyStack {
    int arr [];
    int top;


    MyStack(int capacity){
        arr = new int [capacity];
        top = -1;
    }
    public void push(int key){
        if(isFull() == true){
            System.out.println("Stack is Full, Insertion cannot be done");
            return;
        }
        top++;
        arr[top] = key;

    }
    public int pop(){
        if(isEmpty() == true){
            System.out.println("ERROR:Stack is Empty, Deletion cannot be done");
            return -1;
//            Raise an exception instead of returning -1
        }
        int tmp = arr[top];
        top--;

        return tmp;

    }
    public int peek(){
        if(isEmpty() == true){
            System.out.println("ERROR:Stack is Empty, Deletion cannot be done");
            return -1;
//            Raise an exception instead of returning -1
        }
        return arr[top];
    }

    public boolean isEmpty(){
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull(){
        if (top == arr.length -1)
            return true;
        return false;
    }
    public static void main(String args[]){
        MyStack obj = new MyStack(5);
        obj.push(100);
        obj.push(200);
        obj.push(300);
        obj.push(400);
        obj.push(500);
//        obj.push(600);
        System.out.println("Peek is " + obj.peek());
        System.out.println("Peek is " + obj.peek());
        System.out.println("Pop is " + obj.pop());
        System.out.println("Pop is " + obj.pop());
        System.out.println("Peek is " + obj.peek());
        System.out.println("Pop is " + obj.pop());
        System.out.println("Pop is " + obj.pop());
        System.out.println("Pop is " + obj.pop());
        System.out.println("Pop is " + obj.pop());

    }
}
