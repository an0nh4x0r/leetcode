class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int midIndex;
        int midElement;
        int rowIndex;
        int colIndex;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            midIndex = (low + high) >>> 1;
            rowIndex = midIndex / n;
            colIndex = midIndex % n;
            midElement = matrix[rowIndex][colIndex];

            if (midElement > target) high = midIndex - 1;
            else if (midElement < target) low = midIndex + 1;
            else return true;
        }
        
        return false;
    }
}