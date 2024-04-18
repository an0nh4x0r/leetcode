class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = 0;
        int longest = 0;
        for (int n: nums) {
            set.add(n);
        }

        for (int i: set) {
            if (!set.contains(i - 1)) {
                length = 0;
                while (set.contains(i + length)) {
                    length += 1;
                    longest = Math.max(length, longest);
                }
            }
        }

        return longest;
    }
}