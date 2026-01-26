class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    queue.add(new int[] {r, c});
                } else {
                    dist[r][c] = -1; //mark unvisited
                }
            }
        }
        return BFS(dist, queue, m, n);
    }

    private int[][] BFS(int[][] dist, Deque<int[]> queue, int m, int n) {
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int cr = curr[0], cc = curr[1];

            for (int k = 0; k < DIRS.length; k++) {
                int nr = cr+DIRS[k][0], nc = cc+DIRS[k][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    queue.add(new int[] {nr, nc});
                    dist[nr][nc] = dist[cr][cc]+1;
                }
            }
        }
        return dist;
    }
}
