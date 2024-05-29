class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var card: hand) map.put(card, map.getOrDefault(card, 0) + 1);
        
        Arrays.sort(hand);

        for (int i = 0; i < hand.length; ++i) {
            var card = hand[i];
            if (map.getOrDefault(card, 0) > 0) {
                for (int k = 0; k < groupSize; ++k) {
                    if (map.getOrDefault(card + k, 0) == 0) return false;
                    else map.put(card + k, map.getOrDefault(card + k, 0) - 1);
                }
            }
        }

        return true;
    }
}