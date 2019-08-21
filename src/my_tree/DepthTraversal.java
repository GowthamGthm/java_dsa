package my_tree;

import java.util.LinkedList;
import java.util.Stack;


public class DepthTraversal {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    LinkedList<Integer>result = new LinkedList<>();
    public void preorderTraversal(TreeNode root) {

          if (root == null){
              return ;
          }
          System.out.println(root.val); //ROOT
          preorderTraversal(root.left); //LS
          preorderTraversal(root.right);//RS

    }
    public LinkedList<Integer> preorderIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode>mystk = new Stack();
        TreeNode cur = root;
        while(true) {
            while (cur != null) {
                result.add(cur.val);
                mystk.push(cur);
                cur = cur.left;
            }
            if (mystk.isEmpty() == true)
                break;
            else {
                cur = mystk.pop();
                cur = cur.right;
            }
        }
        return result;
    }

    public void inorderTraversal(TreeNode root) {

        if (root == null){
            return ;
        }
        inorderTraversal(root.left);//LS
        System.out.println(root.val);//ROOT
        inorderTraversal(root.right);//RS

    }
    public void postorderTraversal(TreeNode root) {

        if (root == null){
            return ;
        }
        postorderTraversal(root.left); //LS
        postorderTraversal(root.right);//RS
        System.out.println(root.val);


    }

    public void insertutil(){
        TreeNode root = new TreeNode(10);

        root.left =  new TreeNode(20);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        preorderTraversal(root);
        System.out.println("Inorder traversal");
        inorderTraversal(root);
        System.out.println("Inorder traversal");
        postorderTraversal(root);
    }
    public static void main(String args[]){
        DepthTraversal obj = new DepthTraversal();
        obj.insertutil();
    }
}
