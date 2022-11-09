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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        traverse(root, map, 0);
        for(int level: map.keySet()) {
            ans.add(map.get(level));
        }
        return ans;
    }
    
    public void traverse(TreeNode curr, HashMap<Integer, Integer> map, int level) {
        if (curr == null) return;
        
        map.put(level, curr.val);
        
        traverse(curr.left, map, level + 1);
        traverse(curr.right, map, level + 1);
    }
    
}