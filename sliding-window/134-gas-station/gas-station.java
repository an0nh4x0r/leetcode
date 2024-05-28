class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = 0; // total gas
        int cSum = 0;
        int index = 0;
        int total = 0;

        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i];

            if (total < 0) {
                total = 0;
                index = i + 1;
            }

            gSum += gas[i];
            cSum += cost[i];
        }

        return cSum > gSum ? -1 : index;
    }
}