package my_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>dq = new LinkedList<Integer>();
//        dq.removeLast(); Remove last
//        dq.removeFirst(); Remove First
//        dq.addLast(); INsert Last
//        1  3  -1] -3  5  3  6  7
//            output = > 6 elements
//        8 - 3  => 5 + 1
        int idx = 0;
        int result [] = new int[nums.length - k + 1];
        int top_idx = 0;
//        1, 3, -1
        for (int i=0;i<k;i++){
            if (dq.isEmpty() == true)
                ((LinkedList<Integer>) dq).addLast(i);
            else {
                if (dq.peekLast() == null)
                    System.out.println("Last element is Null");
                else
                    System.out.println("Last element is " + dq.peekLast() + " i is " + i) ;


                while(dq.isEmpty() == false && nums[dq.peekLast()] < nums[i] )
                    dq.removeLast();
                dq.addLast(i);
            }
        }
        result[idx++] = nums[dq.peekFirst()];
        for(int j=k;j<nums.length;j++){
//            Check the first element goes out of the window or not
           if(j - dq.peekFirst() == k){
               dq.removeFirst();
           }
            if (dq.isEmpty() == true)
                ((LinkedList<Integer>) dq).addLast(j);
            else {
                while(dq.isEmpty() == false && nums[dq.peekLast()] < nums[j] )
                    dq.removeLast();
                dq.addLast(j);
            }

            result[idx++] = nums[dq.peekFirst()];
        }

        return result;
    }

    public static void main(String args[]){
        int arr[] = {1,  3,  -1, -3,  5,  3,  6,  7 };
        System.out.println("OUtput is " + Arrays.toString(maxSlidingWindow(arr, 3)));
    }

}
