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
    
    public TreeNode findTail(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        TreeNode rChild = root.right;
        if (root.left != null) {
            flatten(root.left);
            TreeNode lChild = root.left;
            root.left = root.right = null;
            root.right = lChild;
            TreeNode tail = findTail(lChild);
            tail.right = rChild;
        }
    }
}