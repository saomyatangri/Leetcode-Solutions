class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }
    
    private TreeNode helper(TreeNode curr, TreeNode p) {
        if (curr == null) return null;
        if (curr.val <= p.val) {
            return helper(curr.right, p);
        } else {
            TreeNode left = helper(curr.left, p);
            return (left == null) ? curr : left;
        }
    }
}
