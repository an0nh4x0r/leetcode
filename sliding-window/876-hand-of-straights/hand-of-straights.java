class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: hand) map.put(i, map.getOrDefault(i, 0) + 1);

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; ++i) {
            int element = hand[i];
            if (map.getOrDefault(element, 0) > 0) {
                for (int k = 0; k < groupSize; ++k) {
                    if (map.getOrDefault(element + k, 0) == 0) return false;
                    else map.put(element + k, map.get(element + k) - 1);
                }
            } 
        }

        return true;
    }
}