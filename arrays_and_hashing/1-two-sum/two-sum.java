class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                left = i;
                right = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {left, right};
    }
}