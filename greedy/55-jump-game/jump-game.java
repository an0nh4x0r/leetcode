class Solution {
    public boolean canJump(int[] nums) {
        // this index is our end goal
        int goal = nums.length - 1;

        // start with 2nd last index
        for (int i = nums.length - 2; i >= 0; --i) {
            // check from previous index can we reach to goal or not
            // if we can reach, now prev index becomes our goal
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        // at the end, verify if we goal is index 0
        return goal == 0;
    }
}