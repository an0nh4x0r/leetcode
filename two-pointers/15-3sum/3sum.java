class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the input array so that we get similar elements next to each other
        Arrays.sort(nums);
        // response list
        List<List<Integer>> res = new ArrayList<>();

        // outer for loop will leave last 2 elements of the array
        // because we need triplets so will be go till the 3rd last element
        // and front, back pointers will pointer to those last 2 elements
        for (int i = 0; i < nums.length - 2; ++i) {
            // basically we are skipping same elements below
            // if index is 0 go or if index is greater than 0, check if previous element is same
            // skip them if the previous element is same.
            if ((i == 0) || (i > 0 && nums[i] != nums[i - 1])) {
                // sum = triplet[0] + triplet[1] + triplet[2];
                // triplet[1] + triplet[2] = sum - triplet[0]
                // and in question it asked to get triplets such that there sum = 0
                int sum = 0 - nums[i];
                // front pointer
                int front = i + 1;
                // back pointer
                int back = nums.length - 1;

                while (front < back) {
                    // if two pointers sum is greater than the desired sum, decrease back pointer
                    if (nums[front] + nums[back] > sum) {
                        back--;
                    } else if (nums[front] + nums[back] < sum) { // if two pointers sum is lower than the desired sum, increase front pointer
                        front++;
                    } else {
                        // if sum is equal ... add the result to array
                        res.add(Arrays.asList(nums[i], nums[front], nums[back]));

                        // check if front and (front + 1) numbers are same, increase front pointer
                        while (front < back && nums[front] == nums[front + 1]) front++;
                        // check if back and (back - 1) numbers are same, decrease back pointer
                        while (front < back && nums[back] == nums[back - 1]) back--;

                        // increase front and decrease lower pointer
                        // if above two while loops don't run, we go to next element
                        // if above two while loops run, then they just skip duplicates, but we still need to new pointers
                        // because first occurence of duplicates are already added in result and we would now like to go to the new elements
                        front++;
                        back--;
                    }
                }
            }
        }

        return res;
    }
}