class Solution(object):
    def countNodes(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        visited = list()
        self.traverse(root, visited)
        return len(visited)
    
    def traverse(self, node, visited):
        if (node is None or node in visited):
            return
        visited.append(node)
        self.traverse(node.left, visited)
        self.traverse(node.right, visited)
        
