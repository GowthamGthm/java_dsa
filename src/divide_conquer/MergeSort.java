package divide_conquer;

public class MergeSort {
    public void mergeutil(int arr[], int start, int end){
        System.out.println("Start = " + start + " End  =  " + end);
        if (start == end){
            return;
        }
        int mid = (start + end)/2;
        mergeutil(arr, start, mid);
        mergeutil(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int arr[], int start, int mid, int end){
        int count = end - start + 1;
        int temparr[] = new int[count];
        int first = start;
        int second = mid + 1;
        int k = 0;


        for (int j=start;j<=end;j++) {
            if (first > mid) {
                System.out.println("Case 1");
//            Case 1: Copy second list as it is

                temparr[k] = arr[second];
                k++;
                second++;
            } else if (second > end) {
                System.out.println("Case 2");
//            Case 2: Copy first list as it is
                temparr[k] = arr[first];
                k++;
                first++;
            } else if (arr[first] < arr[second]) {
                System.out.println("Case 3");
//            case 3
                temparr[k] = arr[first];
                first++;
                k++;
            } else if (arr[second] < arr[first]) {
                System.out.println("Case 4");
//            case 4
                temparr[k] = arr[second];
                second++;
                k++;
            }
        }
        k = 0;
//        Copy the temp arr to original array
        for(int i=0; i<temparr.length;i++){
            arr[start] = temparr[k];
            k++;
            start++;

        }

    }

    public static void main(String arr[]){
//        int [] arr;
//        int [] intarr  = new int [] {900, 800, 700, 400, 100, 50};
        int [] intarr  = new int [] {900, 800,780,65,1,876, 23, 76};
        MergeSort obj = new MergeSort();
        obj.mergeutil(intarr, 0, intarr.length -1);
//        System.out.println("After Sorting" + arr.toString(Arrays));
        for (int i=0;i<intarr.length;i++){
            System.out.println(intarr[i]);
        }

        return;

    }
}
