class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            int midElement = matrix[rowIndex][colIndex];

            if (midElement == target) return true;
            else if (midElement > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}