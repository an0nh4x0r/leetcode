class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int n: nums) {
            if (map.containsKey(-n)) {
                if (Math.abs(n) > max) max = Math.abs(n);
            } else {
                map.put(n, 1);
            }
        }

        return max;
    }
}