class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; ++num) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // put num in this cell

                            if (solve(board)) {
                                return true; // if it's the solution, return true
                            } else {
                                board[row][col] = '.'; // otherwise, reset and backtrack
                            }
                        }
                    }
                    return false; // if no number from 1-9 works, return false
                }
            }
        }
        return true; // If all cells are correctly filled, return true
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] != '.' && board[i][col] == num) return false; // Check row
            if (board[row][i] != '.' && board[row][i] == num) return false; // Check column
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) return false;
        }

        return true;
    }
}