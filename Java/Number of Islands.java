class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int islands = 0;
        boolean[][] checked = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !checked[i][j] ) {
                    islands++;
                    //System.out.printf("Calling DFS, islands = %d, i = %d, j = %d\n", islands, i, j);
                    DFS(q, grid, checked, i, j);
                }
            }
        }
        return islands;
    }
    
    private void DFS(Queue<int[]> q, char[][] grid, boolean[][] checked, int i, int j) {
        int[] temp = {i, j};
        q.add(temp);
        while(!q.isEmpty()) {
            int[] coord = q.remove();
            int x = coord[0]; int y = coord[1];
            if (!checked[x][y]) {
                checked[x][y] = true;
                if (x+1 < grid.length && grid[x+1][y] == '1' && !checked[x+1][y]) {
                    //System.out.printf("inside DFS 1, old = %d,%d new = %d,%d\n", x, y, x+1, y);
                    int[] temp1 = {x+1, y};
                    q.add(temp1);
                } if (x-1 >= 0 && grid[x-1][y] == '1' && !checked[x-1][y]) {
                    //System.out.printf("inside DFS 2, old = %d,%d new = %d,%d\n", x, y, x-1, y);
                    int[] temp1 = {x-1, y};
                    q.add(temp1);
                } if (y+1 < grid[0].length && grid[x][y+1] == '1' && !checked[x][y+1]) {
                    //System.out.printf("inside DFS 3, old = %d,%d new = %d,%d\n", x, y, x, y+1);
                    int[] temp1 = {x, y+1};
                    q.add(temp1);
                } if (y-1 >= 0 && grid[x][y-1] == '1' && !checked[x][y-1]) {
                    //System.out.printf("inside DFS 4, old = %d,%d new = %d,%d\n", x, y, x, y-1);
                    int[] temp1 = {x, y-1};
                    q.add(temp1);
                }
            }
        }
    }
}
