class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Comparator.reverseOrder());
        int fleet = 0;

        for (int i = 0; i < position.length; ++i) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        double curTime = 0;
        for (double time: map.values()) {
            if (time > curTime) {
                fleet++;
                curTime = time;
            }
        }
        
        return fleet;
    }
}