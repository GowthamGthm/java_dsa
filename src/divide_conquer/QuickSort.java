package com.yogeeshgv.dsa.recursion;

import java.util.Arrays;

public class QuickSort {
    static void sortutil(int arr[], int low, int high){

//        if (low == high)
//            return;
        if(low < high) {
            int mid = partition(arr, low, high);
            sortutil(arr, low, mid - 1);
            sortutil(arr, mid + 1, high);
        }
    }

    static int partition(int arr[], int low, int high){
        System.out.println("arr is " + Arrays.toString(arr) + " low " + low + " high is " + high);
        int i = low + 1;
        int j = high;
        int key = arr[low];
        int temp = 0;
        while (true){
            System.out.println(("i is " + i + " arr[i] is " + arr[i] + " j is " + j + " arr[j] " + arr[j]));
            while(i < arr.length && key >= arr[i]){
                i++;
            }
            while (j < arr.length && key  < arr[j]){
                j--;
            }
            if (i < j){
                System.out.println("Swapping i " + i + " j " + j + " a[i] " + arr[i] +  " arr[j] " +arr[j] );
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
            else{
                temp = arr[low];
                arr[low] = arr[j];
                arr[j] = temp;
                return j;

            }

        }
//        return 0;
    }

    public static void main(String args[]){
        int arr[] = {10, 150, 110, 120, 200, 50, 300, 90, 10};
//        int arr[] = {10, 5, 1, -10};
        sortutil(arr, 0, arr.length - 1);
        System.out.println("After sorting " + Arrays.toString(arr));
    }

}


