package my_stack;
import java.util.Arrays;
import java.util.Stack;

public class TrapRainwater {
//    O(N * N)
    public static int bruteforce(int arr[]){
        int result = 0;
        int left_max = 0;
        int right_max = 0;
        for(int i=0;i<arr.length;i++){

//            Get the left max
            for (int left=i;left>=0;left--){
                if(arr[left] > left_max){
                    left_max = arr[left];
                }
            }
//            Get the right max
            for(int right=i;right<arr.length;right++){
                if(arr[right] > right_max){
                    right_max = arr[right];
                }

            }
            result += Math.min(left_max, right_max) - arr[i];
            left_max = 0;
            right_max = 0;

        }
        return result;
    }

    public static int stack_solution(int arr[]){
        int i = 0;
        int result = 0;
        int height, width;
        Stack<Integer>mystack = new Stack<Integer>();
        int cur =0;
        while (i < arr.length){
            while(mystack.isEmpty() == false   && arr[i] > arr[mystack.peek()]){
                cur = mystack.pop();
                if (mystack.isEmpty() == true)
                    break;
                height = Math.min(arr[mystack.peek()], arr[i]) - arr[cur];
                width = i - mystack.peek() - 1;
                result += height * width;

            }
            mystack.push(i);
            i++;
        }
        return result;

    }
    public static void main(String args[]){
//        int inparr[] = {100, 80, 60, 70, 60, 75, 85};
        int inparr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result ;
        result = bruteforce(inparr);
        System.out.println("Bruteforce approach: Result is " + result);
        result = stack_solution(inparr);
        System.out.println("stack approach: Result is " + result);


    }
}
