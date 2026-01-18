/* My most recent solution, BFS */
class Solution {
    private static final int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //System.out.printf("r: %d, c: %d, grid[r][c]=%c\n", r, c, grid[r][c]);
                if (grid[r][c] == '1') {
                    //System.out.printf("r: %d, c: %d, grid[r][c]=%c", r, c, grid[r][c]);
                    numIslands++;
                    queue.add(new int[]{r, c});
                    grid[r][c] = '0';
                    
                    while (!queue.isEmpty()) {
                        int[] curr = queue.remove();
                        for (int k = 0; k < DIRS.length; k++) {                            
                            int cr = curr[0]; int cc=curr[1];

                            int newR = cr+DIRS[k][0];
                            int newC = cc+DIRS[k][1];
                            if (isValidIndex(newR, newC, rows, cols) && grid[newR][newC] == '1') {
                                queue.add(new int[]{newR, newC});
                                grid[newR][newC] = '0'; //mark visited
                            }
                        }
                    }
                }
            }
        }
        return numIslands;
    }

    private boolean isValidIndex(int newR, int newC, int rows, int cols) {
        return newR >= 0 && newR < rows && newC >= 0 && newC < cols;
    }
}

/* My previous solution, also BFS */
class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int islands = 0;
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !checked[i][j] ) {
                    islands++;
                    //System.out.printf("Calling BFS, islands = %d, i = %d, j = %d\n", islands, i, j);
                    BFS(q, grid, checked, i, j);
                }
            }
        }
        return islands;
    }
    
    private void BFS(Queue<int[]> q, char[][] grid, boolean[][] checked, int i, int j) {
        int[] temp = {i, j};
        q.add(temp);
        while(!q.isEmpty()) {
            int[] coord = q.remove();
            int x = coord[0]; int y = coord[1];
            if (!checked[x][y]) {
                checked[x][y] = true;
                if (x+1 < grid.length && grid[x+1][y] == '1' && !checked[x+1][y]) {
                    //System.out.printf("inside BFS 1, old = %d,%d new = %d,%d\n", x, y, x+1, y);
                    int[] temp1 = {x+1, y};
                    q.add(temp1);
                } if (x-1 >= 0 && grid[x-1][y] == '1' && !checked[x-1][y]) {
                    //System.out.printf("inside BFS 2, old = %d,%d new = %d,%d\n", x, y, x-1, y);
                    int[] temp1 = {x-1, y};
                    q.add(temp1);
                } if (y+1 < grid[0].length && grid[x][y+1] == '1' && !checked[x][y+1]) {
                    //System.out.printf("inside BFS 3, old = %d,%d new = %d,%d\n", x, y, x, y+1);
                    int[] temp1 = {x, y+1};
                    q.add(temp1);
                } if (y-1 >= 0 && grid[x][y-1] == '1' && !checked[x][y-1]) {
                    //System.out.printf("inside BFS 4, old = %d,%d new = %d,%d\n", x, y, x, y-1);
                    int[] temp1 = {x, y-1};
                    q.add(temp1);
                }
            }
        }
    }
}
