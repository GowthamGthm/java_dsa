//https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PreorderIter{
    public List<Integer> preorderTraversal(TreeNode root) {
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
}
