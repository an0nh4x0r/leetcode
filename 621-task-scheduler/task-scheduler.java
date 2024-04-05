class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            int coolDownPeriod = n + 1;
            int taskCount = 0;
            List<Integer> store = new ArrayList<>();

            while(coolDownPeriod-- > 0 && !maxHeap.isEmpty()) {
                int currentFrequency = maxHeap.poll();
                if (currentFrequency > 1) {
                    store.add(currentFrequency - 1);
                }
                taskCount += 1;
            }

            store.forEach(maxHeap::offer);

            cycles += maxHeap.isEmpty() ? taskCount : n + 1;
        }
        
        return cycles;
    }
}