package my_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinRope {

    public static int findMinCost(int arr[]){
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
//        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
//        min_heap.add(100);
//        min_heap.add(300);
//        min_heap.add(500);
//        min_heap.add(400);
//        min_heap.add(900);
//
//        max_heap.add(877);
//        max_heap.add(80);
//        max_heap.add(88888);
//        max_heap.add(87);
//        max_heap.add(80);
        int result = 0;
        int min_fir, min_sec;
        for(int i=0; i<arr.length;i++){
            min_heap.add(arr[i]);
        }
        while(min_heap.size() > 1) {
            min_fir = min_heap.poll();
            min_sec = min_heap.poll();
            result += min_fir + min_sec;
            min_heap.add(min_fir + min_sec);

        }
        System.out.println("MIn ele " + min_heap.peek());
//        System.out.println("Max ele " + max_heap.peek());
        return result;
    }
    public static void main(String args[]){
        int arr[] = {3, 5, 9, 15};
        System.out.println("Mininum cost to join all ropes are " + findMinCost(arr));
    }
}
