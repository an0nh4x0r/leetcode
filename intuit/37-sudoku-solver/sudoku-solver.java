class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; ++num) {
                        if (isValidPlacement(board, num, row, col)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
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
        return !isNumberInRows(board, num, row) && !isNumberInCols(board, num, col)
            && !isNumberInBox(board, num, row, col);
    }

    private boolean isNumberInRows(char[][] board, char num, int row) {
        for (int i = 0; i < 9; ++i) {
            if (board[row][i] == num) {
                return true;
            }
        }

        return false;
    }

    private boolean isNumberInCols(char[][] board, char num, int col) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private boolean isNumberInBox(char[][] board, char num, int row, int col) {
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