class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != '.') {
                    String number = "(" + board[i][j] + ")";
                    if (!seen.add(i + number) || !seen.add(number + j) || !seen.add(i/3 + number + j/3)) return false;
                }
            }
        }

        return true;
    }
}