class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return equal(root.left, root.right);
    }
    
    private boolean equal(TreeNode left, TreeNode right) {
        //failure & success cases
        if (left == null && right == null) return true;
        if (left == null && right != null) return false;
        if (right == null && left != null) return false;
        if (left.val != right.val) return false;
        
        return equal(left.left, right.right) && equal(left.right, right.left);
    }
}
