class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; ++i) {
            int element = hand[i];
            if (map.getOrDefault(element, 0) > 0) {
                map.put(element, map.get(element) - 1);
                for (int k = 1; k < groupSize; ++k) {
                    element++;
                    if (map.getOrDefault(element, 0) == 0) return false;
                    else if (map.get(element) > 0) map.put(element, map.get(element) - 1);
                }
            }
        }
        
        return true;
    }
}