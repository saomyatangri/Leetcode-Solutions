/* 
 * Implementation Strategy: 
 * find every 'O' on an edge, and exclude those
 * flip all that's left to an 'X'
*/

class Solution {
    private static final int[][] DIRS = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] safe = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isEdgeOfBoard(r, c, m, n) && board[r][c] == 'O') {
                    //found O on edge, find full region
                    safe[r][c] = true;
                    DFS(board, safe, r, c, m, n);
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O' && !safe[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void DFS(char[][] board, boolean[][] safe, int r, int c, int m, int n) {
        for (int k = 0; k < DIRS.length; k++) {
            int nr = r+DIRS[k][0], nc = c+DIRS[k][1];
            if (isLegalIndex(nr,nc,m,n) && board[nr][nc] == 'O' && !safe[nr][nc]) {
                safe[nr][nc] = true;
                DFS(board, safe, nr, nc, m, n);
            }
        }
    }

    private boolean isEdgeOfBoard(int r, int c, int m, int n) {
        return r == 0 || r == m-1 || c == 0 || c == n-1;
    }

    private boolean isLegalIndex(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
