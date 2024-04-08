class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(map.values());

        int cycles = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> store = new ArrayList<>();
            int coolDown = n + 1;
            int taskCount = 0;

            while(coolDown-- > 0 && !maxHeap.isEmpty()) {
                int currentFrequency = maxHeap.poll();
                if (currentFrequency > 1) store.add(currentFrequency - 1);
                taskCount++;
            }

            store.forEach(maxHeap::offer);

            cycles += maxHeap.isEmpty() ? taskCount : n + 1;
        }

        return cycles;
    }
}