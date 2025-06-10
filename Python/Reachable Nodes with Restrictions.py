class Solution(object):
    def reachableNodes(self, n, edges, restricted):        
        """
        :type n: int
        :type edges: List[List[int]]
        :type restricted: List[int]
        :rtype: int
        """
        graph = Solution.constructGraph(edges)
        return self.dfs(graph, 0, set(), set(restricted))
                    
    def dfs(self, graph, node, visited, restricted):
        if node in visited or node in restricted:
            return 0
        
        visited.add(node)
        count = 1
        for neighbor in graph[node]:                
            count += self.dfs(graph, neighbor, visited, restricted)
                
        return count
        
    @staticmethod
    def constructGraph(edges):
        graph = {}
        for u,v in edges:
            graph.setdefault(u, []).append(v)
            graph.setdefault(v, []).append(u) 
        return graph


        
