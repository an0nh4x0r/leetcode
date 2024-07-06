class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; ++num) {
                        if (isValidPlacement(board, num, i, j)) {
                            board[i][j] = num;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPlacement(char[][] board, char num, int row, int col) {
        return !inRow(board, num, row) && !inCol(board, num, col)
                && !inBox(board, num, row, col);
    }

    private boolean inRow(char[][] board, char num, int row) {
        for (int i = 0; i < 9; ++i) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean inCol(char[][] board, char num, int col) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean inBox(char[][] board, char num, int row, int col) {
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for (int i = localRow; i < localRow + 3; ++i) {
            for (int j = localCol; j < localCol + 3; ++j) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }
}