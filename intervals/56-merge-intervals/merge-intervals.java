class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        res.add(prev);
        
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
                prev = intervals[i];
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}