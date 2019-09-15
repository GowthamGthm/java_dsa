/**
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean findPath(TreeNode root, int key,List<TreeNode>path){
         if(root == null)
             return false;
         path.add(root);
         if(root.val == key)
             return true;
         Boolean left, right;
         left = findPath(root.left, key, path);
         if (left == true)
             return true;
         right = findPath(root.right, key, path);
         if(right == true)
             return true;
         path.remove(path.size()-1);
         return false;
    }

      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         List<TreeNode>path1 = new ArrayList<TreeNode>();
         List<TreeNode>path2 = new ArrayList<TreeNode>();

         Boolean left, right;
         left = findPath(root, p.val, path1);
         right = findPath(root, q.val, path2);
         if(left == false || right == false)
             return null;
         int i =0;
//                               i
//                 path1: 10 20 30
//                 path2: 10 20 40
         for(i=0;i<path1.size() && i<path2.size();i++)
             if(!path1.get(i).equals(path2.get(i)))
                 break;
         return path1.get(i-1);

     }

}
