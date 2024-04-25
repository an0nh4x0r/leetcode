class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task: tasks) map.put(task, map.getOrDefault(task, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(map.values());

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            int coolingInterval = n + 1;
            List<Integer> temp = new ArrayList<>();
            int count = 0;
            
            while (!maxHeap.isEmpty() && coolingInterval-- > 0) {
                int frequency = maxHeap.poll();
                if (frequency > 1) temp.add(frequency - 1);
                count++;
            }

            temp.forEach(maxHeap::offer);
            cycles += maxHeap.isEmpty() ? count : n + 1;
        }
        return cycles;
    }
}