/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }
    
    private void helper(List<Integer> l, TreeNode root) {
        if (root == null) return;
        helper(l, root.left);
        l.add(root.val);
        helper(l, root.right);
    }
}
