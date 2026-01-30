class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int k = 0; k < n; k++) {
            Set<Integer> temp = new HashSet<>();
            adjacencyList.put(k, temp);
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        return DFS(adjacencyList, visited, source, destination);
    }

    private boolean DFS(Map<Integer, Set<Integer>> adjacencyList, Set<Integer> visited, int source, int destination) {
        if (source == destination) {
            //success case, path exists
            return true;
        }
        visited.add(source);
        for (Integer node : adjacencyList.get(source)) {
            if (!visited.contains(node)) {
                if (DFS(adjacencyList, visited, node, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
