class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0; 
        int right = height.length - 1;

        while (left < right) {
            // (right - left) will give me width
            // and we need to take the minimum height such that the water doesn't spill to get the actual height
            int area = (right - left)* Math.min(height[left], height[right]);
            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}