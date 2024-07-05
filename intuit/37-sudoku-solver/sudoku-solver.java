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
        return !isNumberInRow(board, num, row)
                && !isNumberInCol(board, num, col) && !isNumberInBox(board, num, row, col);
    }

    private boolean isNumberInRow(char[][] board, char num, int row) {
        for (int i = 0; i < 9; ++i) {
            if (board[row][i] == num) {
                return true;
            }
        }

        return false;
    }

    private boolean isNumberInCol(char[][] board, char num, int col) {
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == num) {
                return true;
            }
        }

        return false;
    }

    private boolean isNumberInBox(char[][] board, char num, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; ++i) {
            for (int j = localBoxCol; j < localBoxCol + 3; ++j) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }
}