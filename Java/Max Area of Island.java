class Solution {
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,-1}, {0,1}};

    public int maxAreaOfIsland(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        int max = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    
                    //found island, find it's size
                    queue.add(new int[]{r,c});
                    int count = 0;
                    grid[r][c] = 0;

                    while (!queue.isEmpty()) {
                        int[] curr = queue.remove();
                        int tr = curr[0], tc = curr[1];
                        count++;

                        for (int k = 0; k < DIRS.length; k++) {
                            int nr = tr+DIRS[k][0], nc = tc+DIRS[k][1];
                            if (isValidIndex(nr, nc, rows, cols) && grid[nr][nc] == 1) {
                                grid[nr][nc] = 0; //mark this as visited
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }
                    if (count > max) max = count;
                }
            }
        }
        return max;
    }

    private boolean isValidIndex(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
