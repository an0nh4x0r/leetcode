class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String number = "(" + board[i][j] + ")";
                    if (!seen.add(number + i) || !seen.add(j + number) || !seen.add(j/3 + number + i/3)) return false;
                }
            }
        }

        return true;        
    }
}