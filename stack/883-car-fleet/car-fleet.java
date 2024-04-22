class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());

        // DISTANCE = SPEED * TIME 
        // TIME = DISTANCE / SPEED
        // WE are getting the positions as key and time as value
        // this treemap works stores the position in descending order
        for (int i = 0; i < position.length; ++i) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        double currentTime = 0;
        int result = 0;

        // if a car is taking more time, then the previous car, in the treemap.
        // it is considered a new car fleet.
        for (double time: map.values()) {
            if (time > currentTime) {
                currentTime = time;
                result++;
            }
        }

        return result;
    }
}