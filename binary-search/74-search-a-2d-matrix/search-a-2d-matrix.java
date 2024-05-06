class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // calculate the rows and columns
        int rows = matrix.length;
        int cols = matrix[0].length;

        // create the variable for midIndex, midElement
        // rowIndex, colIndex
        int midIndex;
        int midElement;
        int rowIndex;
        int colIndex;

        // initialize low and high variable
        // set low to 0
        // set high to ((rows * cols) - 1)
        int low = 0;
        int high = rows * cols - 1;

        // for binary search this is the template
        // low should be less than or equal to high
        while (low <= high) {
            // >>> this is unsigned right shift operator
            // which makes sure to perform the division 
            // This ensures that the division is performed 
            // without considering the sign of the operands.
            midIndex = (low + high) >>> 1;

            // rowIndex = midIndex / cols
            rowIndex = midIndex / cols;
            // colIndex = midIndex % cols
            colIndex = midIndex % cols;

            // get the midElement using the rowIndex and colIndex
            midElement = matrix[rowIndex][colIndex];

            // now perform the standard binary search template
            if (midElement > target) high = midIndex - 1;
            else if (midElement < target) low = midIndex + 1;
            else return true; 
        }

        return false;
    }
}