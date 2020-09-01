class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
//Success case: Board is filled, no empty spaces left
//Failure case: No number fits for current position, backtrack and fix previous
    
    public boolean solve(char[][] board) { 
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                
                if (board[r][c] == '.') {
                    
                    for (char i = '1'; i <= '9'; i++) {
                        if (isValid(board, r, c, i)) {
                            board[r][c] = i;
                            
                            if (solve(board)) return true;
                            else board[r][c] = '.';
                        }
                    }
                    
                    return false;
                
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        //check rows
        for (int c = 0; c < 9; c++) {
            if (board[row][c] == num) return false;
        }
        
        //check cols
        for (int r = 0; r < 9; r++) {
            if (board[r][col] == num) return false;
        }
        
        //check sub-boxes
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int r = startRow; r < startRow+3; r++) {
            for (int c = startCol; c < startCol+3; c++) {
                if (board[r][c] == num) return false;
            }
        }
        
        return true;
    }
}
