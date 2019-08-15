package divide_conquer;

import java.util.Arrays;

public class MaxSubarray {

    static int subarray_util(int arr[], int start, int end){
        int left_sum = Integer.MIN_VALUE;
        int right_sum = Integer.MIN_VALUE;
        int current = 0;
        int cur_sum = 0;

        if (start == end){
            return arr[start];
        }
//           is      m    e
//        {300, -100, 200}
        int mid = (end + start )/2;
//        System.out.println("Start is  " + start + " Mid is " + mid + "End is " + end);
//        Get the  left sum
        for(int i = mid;i>=0;i--){
            cur_sum = cur_sum + arr[i];
            if (cur_sum > left_sum){
                left_sum = cur_sum;
            }

        }
//        System.out.println("Left Sum is " + left_sum);
        cur_sum = 0;
//Get the right sum
        for(int j = mid+1;j<=end;j++){
            cur_sum = cur_sum + arr[j];
            if (cur_sum > right_sum){
                right_sum = cur_sum;
            }

        }
//        System.out.println("Right  Sum is " + right_sum);
        current = left_sum + right_sum;
//        int left_child, right_child;
//        left_child = subarray_util(arr, start, mid);
//        right_child = subarray_util(arr, mid+1, end);
        int child_value;
        child_value = Math.max(subarray_util(arr, start, mid), subarray_util(arr, mid+1, end));
        return Math.max(current, child_value);

    }
    static int kadane(int arr[]){
        int cur_sum = 0;
        int max_start = 0;
        int max_end = 0;

        int start = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            cur_sum = cur_sum + arr[i];
            if (cur_sum > max_sum ){
                max_sum = cur_sum;
                max_start = start;
                max_end = i;
            }
            if(cur_sum < 0){
                cur_sum = 0;
                start = i + 1;
            }
        }
        System.out.println("Max sum is " + max_sum + "Start idx is " + max_start  + " End idx is " + max_end);
        return   max_sum;
    }
    public static void main(String args[]) {
//        int [] arr;
//        int [] intarr  = new int [] {900, 800, 700, 400, 100, 50};
        int[] intarr = new int[]{-3000,100 , 100, 800,-300, 2000};
        int answer = 0;
        answer = subarray_util(intarr, 0, intarr.length - 1);

        System.out.println("DC 0(N*LOGN): Maximum subarray of " + Arrays.toString((intarr)) + " is " + answer);

        answer = kadane(intarr);
        System.out.println("0(N): Maximum subarray of " + Arrays.toString((intarr)) + " is " + answer);

//        System.out.println("After Sorting" + arr.toString(Arrays));

        return;

    }
}
