# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
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
        
