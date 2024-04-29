class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < position.length; ++i) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        double maxTime = 0;
        int fleet = 0;

        for (double time: map.values()) {
            if (time > maxTime) {
                maxTime = time;
                fleet += 1;
            }
        }
        
        return fleet;
    }
}