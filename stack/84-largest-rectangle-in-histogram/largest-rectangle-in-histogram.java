class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; ++i) {
            int startIndex = i;

            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] temp = stack.pop();
                int height = temp[1];
                int prevIndex = temp[0];
                maxArea = Math.max(maxArea, height * (i - prevIndex));
                startIndex = prevIndex;
            }

            stack.push(new int[] {startIndex, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] element = stack.pop();
            int height = element[1];
            int index = element[0];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}