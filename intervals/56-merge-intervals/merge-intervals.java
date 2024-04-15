class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] currInterval = intervals[0];
        res.add(currInterval);
        for (int i = 1; i < intervals.length; ++i) {
            if (currInterval[1] >= intervals[i][0]) {
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
                currInterval = intervals[i];
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}