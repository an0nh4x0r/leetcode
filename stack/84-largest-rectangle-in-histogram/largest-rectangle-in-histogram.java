class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; ++i) {
            int startIndex = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] temp = stack.pop();
                int prevIndex = temp[0];
                int prevHeight = temp[1];
                maxArea = Math.max(maxArea, prevHeight * (i - prevIndex));
                startIndex = prevIndex;
            }

            stack.push(new int[] {startIndex, heights[i]});
        }

        while (!stack.isEmpty()) {
            int temp[] = stack.pop();
            int prevIndex = temp[0];
            int prevHeight = temp[1];
            maxArea = Math.max(maxArea, prevHeight * (heights.length - prevIndex));
        }

        return maxArea;        
    }
}