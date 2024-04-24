class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int i = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int[] originalQuery = new int[queries.length];

        for (int q = 0; q < queries.length; ++q) {
            originalQuery[q] = queries[q];
        }

        Arrays.sort(queries);

        for (int query: queries) {
            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            if (minHeap.isEmpty()) {
                map.put(query, -1);
            } else {
                map.put(query, minHeap.peek()[0]);
            }
        }

        int[] res = new int[queries.length];

        for (int j = 0; j < originalQuery.length; ++j) {
            res[j] = map.get(originalQuery[j]);
        }

        return res;
    }
}