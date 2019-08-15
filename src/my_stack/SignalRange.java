package my_stack;

import java.util.Arrays;
import java.util.Stack;
/*
1)
Various signal towers are present in a city.
Towers are aligned in a straight horizontal line(from left to right) and
 each tower transmits a signal in the right to left direction.
 Tower A shall block the signal of Tower B if Tower A is present to the left of
 Tower B and Tower A is taller than Tower B. So,the range of a signal of a given
 tower can be defined as :

{(the number of contiguous towers just to the left of the given tower whose height
 is less than or equal to the height of the given tower) + 1}.

You need to find the range of each tower.
Example:
                        i
Input: 100 80 60 70 60 75 85
            j

                 2

        1  1  0  0  0  4  0
Output: 1 1 1 2 1 4 6

900 800 700 600
 */
//Complexity is 0(N * N)
public class SignalRange {
    public static int [] findRange(int arr[]){
        int result[] = new int[arr.length];
        result[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=i;j>=0;j--){
                if(arr[j] <= arr[i]){
                    result[i] += 1;
                }
                else{
                    break;
                }
            }

        }
        return result;
    }
    public static int[] stack_solution(int arr[]){
        int result[] = new int[arr.length];
        Stack<Integer> mystack = new Stack<Integer>();
        int i=0;
        while (i < arr.length){
            while(mystack.isEmpty() == false && arr[i]>=arr[mystack.peek()]){
                mystack.pop();
            }
            if(mystack.isEmpty() == true){
                result[i] = i + 1;
            }
            else {
                result[i] = i - mystack.peek();
            }
            mystack.push(i);
            i++;
        }
        return result;
    }
    public static void main(String args[]){
        int inparr[] = {100, 80, 60, 70, 60, 75, 85};
        int result [];
        result = findRange(inparr);
        System.out.println("Bruteforce approach: Result is " + Arrays.toString(result));
        result = stack_solution(inparr);
        System.out.println("Stack based approach: Result is " + Arrays.toString(result));
    }

}
