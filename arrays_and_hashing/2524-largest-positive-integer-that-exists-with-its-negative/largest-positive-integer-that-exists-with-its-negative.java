class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        maxHeap.addAll(map.keySet());

        while (!maxHeap.isEmpty()) {
            int temp = maxHeap.poll();
            if (map.containsKey(-1 * temp)) return temp;
        }

        return -1;
    }
}