class Solution {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];
        constructList(prerequisites, numCourses);
        
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && DFS(state, i) == false) return false;
        }
        return true;
    }

    private boolean DFS(int[] state, int curr) {
        if (state[curr] == 1) {
            //recursively visiting a node that's already visited
            return false;
        } else if (state[curr] == 2) {
            //visited a node that's already been visited
            return true;
        }
        state[curr] = 1;
        for (int neighbor : adjacencyList.get(curr)) {
            if (DFS(state, neighbor) == false) return false;
        }
        state[curr] = 2;
        return true;
    }
 
    private void constructList(int[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < grid.length; i++) {
            int a = grid[i][0], b = grid[i][1];
            adjacencyList.get(b).add(a);
        }
    }
}
