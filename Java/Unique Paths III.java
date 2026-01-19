class Solution {
    private static final int[][] DIRS = {{0,1}, {0,-1}, {-1,0}, {1,0}}; //up, down, left, right
    private int numPaths = 0;
    private int sr = -1;
    private int sc = -1;

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int numToVisit = getVisitedAndStart(grid, rows, cols);
        numUniquePaths(visited, grid, sr, sc, rows, cols, numToVisit);  
        return numPaths;
    }

    private void numUniquePaths(boolean[][] visited, int[][] grid, int r, int c, int rows, int cols, int remaining) {        
        if (!isValidIndex(r, c, rows, cols) || grid[r][c] == -1 || visited[r][c]) {
            //failure case, not reachable   
            return;
        }
        if (grid[r][c] == 2 && remaining == 1) {
            //success case, finished path
            numPaths++;
        }      
        
        visited[r][c] = true;
        for (int k = 0; k < DIRS.length; k++) {
            //iterate in order of up, down, left, right
            int nr = r+DIRS[k][0], nc = c+DIRS[k][1];
            if (isValidIndex(nr, nc, rows, cols) && grid[nr][nc] != -1 && !visited[nr][nc]) {
                numUniquePaths(visited, grid, nr, nc, rows, cols, remaining-1);
            }
        }
        visited[r][c] = false;
    }

    private int getVisitedAndStart(int[][] grid, int rows, int cols) {
        int numToVisit = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int curr = grid[r][c];
                if (curr != -1) {
                    numToVisit++;
                }
                if (curr == 1) {
                    //found starting square
                    sr = r; sc = c;
                }
            }
        }
        return numToVisit;
    }

    private boolean isValidIndex(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
