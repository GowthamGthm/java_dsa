package my_stack;

import java.util.Stack;

public class LargestRectangle {
//    0(N*N)
    public static int largest_area_bruteforce(int arr[]){
        int num_left = 0;
        int num_right = 0;
        int cur_area=0;
        int max_area = 0;
        for (int i=0;i<arr.length;i++){
            for(int l = i-1;l>=0;l--){
                if (arr[l] < arr[i]){
                    break;
                }
                num_left++;

//                Traverse left till it reaches 0th element;
            }
            for(int r=i+1;r<arr.length;r++){
                if(arr[r] < arr[i])
                    break;
                num_right++;
//                Traverse right till it reaches Nth element;
            }
           cur_area =  (num_left + num_right + 1) * arr[i];
            if (max_area < cur_area){
                max_area = cur_area;
            }
            num_left = 0;
            num_right = 0;

        }
        return max_area;
    }
    public static int largest_area_stack(int arr[]){
        Stack<Integer>mystk = new Stack<Integer>();
        int i = 0;
        int distance, cur, area, max_area = 0;
        while (i < arr.length){
            while(mystk.isEmpty() == false && arr[i]<arr[mystk.peek()]){
                cur = mystk.pop();
                if(mystk.isEmpty() == false){
                    distance = i - mystk.peek()-1;
                }
                else{
                    distance = i;
                }
                area = arr[cur] * distance;
                if (max_area < area)
                    max_area = area;
            }
            mystk.push(i);
            i++;
        }
        while(mystk.isEmpty() == false){
            cur = mystk.pop();
            if(mystk.isEmpty() == false){
                distance = i - mystk.peek()-1;
            }
            else{
                distance = i;
            }
            area = arr[cur] * distance;
            if (max_area < area)
                max_area = area;

        }
        return max_area;
    }

    public  static void main(String args[]){
        int arr[]= {8, 7, 6, 80, 150, 100};
        System.out.println("BRUTEFORCE: Largest Area of histogram is " + largest_area_bruteforce(arr));
        System.out.println("STACKBASEDSOL: Largest Area of histogram is " + largest_area_stack(arr));

    }
}
