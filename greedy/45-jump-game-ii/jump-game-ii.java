class Solution {
    public int jump(int[] nums) {
        // left and right pointers to traverse sequentially
        int left = 0;
        int right = 0;

        // to track the maximum jump value while traversing between left and right pointers
        int maxJump = 0;

        // this is our result, the final jump count
        int jump = 0;

        // while the right pointer is less than end of input array
        while (right < nums.length - 1) {
            // traverse from the left to right pointer, and calculate the maximum jump value
            for (int i = left; i <= right; ++i) {
                maxJump = Math.max(maxJump, nums[i] + i);
            }

            
            left = right + 1; // left pointer will move to right + 1
            right = maxJump; // right will move to the maxJump value, calculated above
            jump += 1; // jump count
        } 

        // return the final response
        return jump;
    }
}