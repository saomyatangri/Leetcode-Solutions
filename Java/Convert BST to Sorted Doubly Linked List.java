class Solution {
    
    Node head = new Node(0, null, null);
    Node listCurr = head;
    Node listPrev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        helper(root);        
        head.left = listPrev;
        listPrev.right = head;
        return head;
    }
    
    private void helper(Node treeNode) {
        if (treeNode == null) return;
        
        helper(treeNode.left);
        listCurr.val = treeNode.val;
        listCurr.left = listPrev;
        if (listPrev != null) {
            listPrev.right = listCurr;
        }            
        listPrev = listCurr;
        listCurr = new Node();
        helper(treeNode.right);
    }
}
