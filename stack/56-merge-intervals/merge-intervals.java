class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prevInterval = intervals[0];
        res.add(prevInterval);
        for (int i = 1; i < intervals.length; ++i) {
            if (prevInterval[1] < intervals[i][0]) {
                res.add(intervals[i]);
                prevInterval = intervals[i];
            } else {
                prevInterval[0] = Math.min(prevInterval[0], intervals[i][0]);
                prevInterval[1] = Math.max(prevInterval[1], intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}