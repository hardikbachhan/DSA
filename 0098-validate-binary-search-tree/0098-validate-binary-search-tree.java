/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean traverse(TreeNode curr, long start, long end) {
        if (curr == null) return true;
        if (start >= (long)curr.val || end <= (long)curr.val) return false;
        return traverse(curr.left, start, (long)curr.val) && traverse(curr.right, (long)curr.val, end);
    }
}