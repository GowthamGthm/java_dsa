/**
https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left, right;
        left = maxDepth(root.left);
        right = maxDepth(root.right);
        return (1 + Math.max(left, right));
        
    }
}
