class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        int longest = 0;
        for (int n: nums) set.add(n);

        for (int n: set) {
            if (!set.contains(n - 1)) {
                length = 0;
                while (set.contains(n + length)) {
                    length++;
                    longest = Math.max(longest, length);
                }
            }
        }

        return longest;
    }
}