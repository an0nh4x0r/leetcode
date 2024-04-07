class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = 0;
        int cSum = 0;
        if (gSum < cSum) return -1;

        int index = 0;
        int totalCost = 0;
        for (int i = 0; i < cost.length; ++i) {
            totalCost += gas[i] - cost[i];
            if (totalCost < 0) {
                totalCost = 0;
                index = i + 1;
            }
            gSum += gas[i];
            cSum += cost[i];
        }

        return cSum > gSum ? -1 : index;        
    }
}