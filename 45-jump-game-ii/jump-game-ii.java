class Solution {
    public int jump(int[] nums) {
        int maxJump = 0;
        int left = 0;
        int right = 0;
        int jump = 0;

        while (right < nums.length - 1) {
            for (int i = left; i <= right; ++i) {
                maxJump = Math.max(maxJump, nums[i] + i);
            }
            left = right + 1;
            right = maxJump;
            jump += 1;
        }

        return jump;        
    }
}