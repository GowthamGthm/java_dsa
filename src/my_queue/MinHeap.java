package my_queue;

import java.util.Arrays;

public class MinHeap {
    int capacity;
    int size;
    int arr[];

    public MinHeap(int cap){
        capacity = cap;
        size = 0;
        arr = new int[cap];
    }
// 2 * i + 1
    public int leftChild(int idx){
        return (2 * idx) + 1;
    }

    public int rightChild(int idx){
        return (2 * idx) + 2;
    }

    public int parent(int idx){
        return (idx - 1) / 2;
    }

    public void insert(int ele){
        arr[size] = ele;
        int i = size;
        int pi = parent(i);
        while((i != pi) && arr[pi] > arr[i]) {
            swap(pi, i);
            i = pi;
            pi = parent(i);
        }
        size++;
        return ;
    }

    public void minHeapify(int i){
        int small = i;
        int lc = leftChild(i);
        int rc = rightChild(i);

        if(lc < size && arr[lc] < arr[small]){
            small = lc;

        }
        if(rc < size && arr[rc] < arr[small])
            small = rc;

        if(small != i){
//            Swap small and i and call the function recursively!!!
            swap(small, i);
            minHeapify(small);

        }



    }
    public int pop(){
        int ele = arr[0];
        swap(0,size-1);
        size--;
        minHeapify(0);

        return ele;
    }

    public int getMin(){
        return arr[0];
    }

    public void swap(int src, int des){
        int temp = arr[src];
        arr[src] = arr[des];
        arr[des] = temp;
    }
    public static void main(String args[]){
        MinHeap mh = new MinHeap(10);
        mh.insert(100);
        mh.insert(200);
        mh.insert(300);
        mh.insert(1);
        mh.insert(25);
//        System.out.println("Array is " + Arrays.toString(mh.arr));
        mh.insert(5);
        mh.insert(3);
        int myarr[] = {250, 100, 20, 14, 25, 91};
        System.out.println("Remove top element " + mh.pop());
        System.out.println("PQ size is " + mh.size);
//        System.out.println("Get min is " + mh.getMin());
        System.out.println("Array is " + Arrays.toString(mh.arr));
    }

}
