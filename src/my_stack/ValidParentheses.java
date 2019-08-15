package my_stack;

import java.util.Stack;

public class ValidParentheses {
    public static Boolean   isvalid(String str){
        Stack<Character> mystack = new Stack<Character>();
        char myarr[] = str.toCharArray();
        for(int i=0;i<myarr.length;i++){
            if (myarr[i] == '{' || myarr[i] == '(' || myarr[i] == '['){
                mystack.push((myarr[i]));
            }
            else {
                if (myarr[i] == '}'){
                    if (mystack.isEmpty() == true){
                        return false;
                    }
                    char cur = mystack.pop();
                    if (cur != '{')
                        return false;

                }
                else if(myarr[i] == ')'){
                    if (mystack.isEmpty() == true){
                        return false;
                    }
                    char cur = mystack.pop();
                    if (cur != '(')
                        return false;

                }
                else if(myarr[i] == ']'){
                    if (mystack.isEmpty() == true){
                        return false;
                    }
                    char cur = mystack.pop();
                    if (cur != '[')
                        return false;
                }
            }
        }
        if (mystack.isEmpty() == true)
            return true;
        return false;
    }
    public static void main(String args[]){
       Boolean result =  isvalid("{[]][}");
       if (result){
           System.out.println("Balanced!!!!");
       }
       else{
           System.out.println("Not Balanced!!!!");
       }
    }
}
