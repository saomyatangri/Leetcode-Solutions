class Solution {
    private static final int[][] DIRS = {{1,0},{1,1},{0,1},{-1,0},{-1,-1},{0,-1},{-1,1},{1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0}); grid[0][0] = -1;
        int[][] dist = new int[n][n]; dist[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int cr = curr[0], cc = curr[1];
            if (cr == n-1 && cc == n-1) {
                //reached end of grid
                return dist[cr][cc];
            }

            for (int k = 0; k < DIRS.length; k++) {
                int nr = cr+DIRS[k][0], nc = cc+DIRS[k][1];
                if (isLegalIndex(nr, nc, n) && grid[nr][nc] == 0) {
                    queue.add(new int[] {nr, nc});
                    dist[nr][nc] = dist[cr][cc]+1;  
                    grid[nr][nc] = -1; //mark visited  

                }
            }
        }
        return -1;
    }

    private boolean isLegalIndex(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
