class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] originalQueries = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) originalQueries[i] = queries[i];

        Arrays.sort(queries);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];
        int j = 0;
        for(int i = 0; i < queries.length; ++i) {
            while (j < intervals.length && intervals[j][0] <= queries[i]) {
                minHeap.offer(new int[] {intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < queries[i]) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                map.put(queries[i], -1);
            } else {
                map.put(queries[i], minHeap.peek()[0]);
            }
        }

        for (int i = 0; i < originalQueries.length; ++i) ans[i] = map.get(originalQueries[i]);

        return ans;
    }
}