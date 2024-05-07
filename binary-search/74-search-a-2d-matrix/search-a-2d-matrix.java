class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = rows * cols - 1;

        int midIndex, midElement, rowIndex, colIndex;

        while (low <= high) {
            midIndex = (low + high) >>> 1;
            rowIndex = midIndex / cols;
            colIndex = midIndex % cols;
            midElement = matrix[rowIndex][colIndex];

            if (target > midElement) low = midIndex + 1;
            else if (target < midElement) high = midIndex - 1;
            else return true;
        }

        return false;
    }
}