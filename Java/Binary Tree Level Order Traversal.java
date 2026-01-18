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

/* BFS Iterative Approach */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return output;
        
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            TreeNode node = queue.peek();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                level.add(node.val);
            }
            output.add(level);
        }
        return output;
    }
}

/* DFS Recursive Approach */
class Solution2 {
    List<List<Integer>> output = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);
        return output;
    }

    private void traverse(TreeNode node, int height) {
        if (node == null) return;
        
        if (output.size() <= height) {
            //first element found at this level
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            output.add(height, list);
        } else {
            //level already exists, add to it
            output.get(height).add(node.val);
        }
        traverse(node.left, height+1);
        traverse(node.right, height+1);
    }
}
