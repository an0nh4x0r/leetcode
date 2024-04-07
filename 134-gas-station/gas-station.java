class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = Arrays.stream(gas).sum();
        int cSum = Arrays.stream(cost).sum();

        if (gSum < cSum) return -1;

        int index = 0;
        int totalCost = 0;
        for (int i = 0; i < cost.length; ++i) {
            totalCost += gas[i] - cost[i];
            if (totalCost < 0) {
                totalCost = 0;
                index = i + 1;
            }
        }

        return index;        
    }
}