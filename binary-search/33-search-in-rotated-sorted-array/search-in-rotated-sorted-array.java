class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int comparator = nums[mid];

            if ((target < nums[0] && nums[mid] < nums[0]) || (target >= nums[0] && nums[mid] >= nums[0])) {
                comparator = nums[mid];
            } else {
                if (target < nums[0]) {
                    comparator = Integer.MIN_VALUE;
                } else {
                    comparator = Integer.MAX_VALUE;
                }
            }

            if (comparator > target) right = mid - 1;
            else if (comparator < target) left = mid + 1;
            else return mid;
        }

        return -1;
    }
}