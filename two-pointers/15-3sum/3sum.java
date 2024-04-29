class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int sum = 0 - nums[i];
                int front = i + 1;
                int back = nums.length - 1;

                while (front < back) {
                    if (nums[front] + nums[back] == sum) {
                        res.add(Arrays.asList(nums[i], nums[front], nums[back]));

                        while (front < back && nums[front] == nums[front + 1]) front++;
                        while (front < back && nums[back] == nums[back - 1]) back--;

                        front++;
                        back--;
                    } else if (nums[front] + nums[back] > sum) back--;
                    else if (nums[front] + nums[back] < sum) front++;
                }
            }
        }

        return res;
    }
}