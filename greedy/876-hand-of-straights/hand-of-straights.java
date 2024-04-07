class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < hand.length; ++i) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        minHeap.addAll(map.keySet());
        boolean isConsecutive = true;

        while (!minHeap.isEmpty()) {
            List<int[]> store = new ArrayList<>();
            List<Integer> consecutive = new ArrayList<>();
            
            for (int i = 0; i < groupSize && !minHeap.isEmpty(); ++i) {
                int currentNum = minHeap.poll();
                int currentFreq = map.get(currentNum);
                if (currentFreq > 1) store.add(new int[] {currentNum, currentFreq - 1});
                consecutive.add(currentNum);
            }

            if (consecutive.size() < groupSize) {
                isConsecutive = false;
                break;
            }

            for (int i = 0; i < store.size(); ++i) {
                int[] element = store.get(i);
                minHeap.offer(element[0]);
                map.put(element[0], element[1]);
            }

            int el = consecutive.get(0);
            for (int i = 1; i < consecutive.size(); ++i) {
                if (el + 1 != consecutive.get(i)) {
                    isConsecutive = false;
                    break;
                }
                el = consecutive.get(i);
            }

            if (!isConsecutive) break;
        }

        return isConsecutive;
    }
}