class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                index1 = i;
                index2 = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }

        return new int[] {index1, index2};
    }
}