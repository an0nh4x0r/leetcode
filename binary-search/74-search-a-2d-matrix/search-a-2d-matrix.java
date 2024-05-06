class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows * columns - 1;
        
        int midIndex;
        int midElement;
        int rowIndex;
        int colIndex;

        while (low <= high) {
            midIndex = (low + high) >>> 1;
            
            rowIndex = midIndex / columns;
            colIndex = midIndex % columns;

            midElement = matrix[rowIndex][colIndex];

            if (midElement > target) high = midIndex - 1;
            else if(midElement < target) low = midIndex + 1;
            else return true;
        }

        return false;  
    }
}