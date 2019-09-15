/**
https://leetcode.com/problems/diameter-of-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int diameter;
    Solution(){
        diameter = 0;
    }
    public int diameterUtil(TreeNode root){
        if (root == null)
            return 0;
        int left, right;
        left = diameterUtil(root.left);
        right = diameterUtil(root.right);
        diameter = Math.max((left+right),diameter);
        return 1 + Math.max(left, right);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameterUtil(root);
        return diameter;
        
    }
}
