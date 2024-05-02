class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        int[] res = new int[k];

        for (int i = 0; i < k && !maxHeap.isEmpty(); ++i) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}