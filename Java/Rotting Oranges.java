class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int EMPTY = 0;
    private static final int FRESH_ORANGE = 1;
    private static final int ROTTEN_ORANGE = 2;

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == FRESH_ORANGE) {
                    dist[r][c] = -1;
                } else if (grid[r][c] == ROTTEN_ORANGE) {
                    queue.add(new int[] {r,c});
                }
            }
        }
        
        dist = BFS(grid, dist, queue, m, n);
        return checkOutput(dist, m, n);
    }

    private int[][] BFS(int[][] grid, int dist[][], Deque<int[]> queue, int m, int n) {
        while(!queue.isEmpty()) {
            int[] curr = queue.remove();
            int cr = curr[0], cc = curr[1];

            for (int k = 0; k < DIRS.length; k++) {
                int nr = cr+DIRS[k][0], nc = cc+DIRS[k][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == FRESH_ORANGE) {
                    queue.add(new int[] {nr, nc});
                    dist[nr][nc] = dist[cr][cc]+1;
                    grid[nr][nc] = ROTTEN_ORANGE;
                }
            }
        }
        return dist;
    }

    private int checkOutput(int[][] dist, int m, int n) {
        int minutes = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dist[r][c] == -1) {
                    return -1;
                } else {
                    minutes = Math.max(minutes, dist[r][c]);
                }
            }
        }
        return minutes;
    }
}
