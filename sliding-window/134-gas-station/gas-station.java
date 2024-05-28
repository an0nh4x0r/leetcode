class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = 0; // total gas counter
        int cSum = 0; // total cost counter
        int index = 0; // result index tracker
        int total = 0; // total is difference of gas[i] - cost[i]

        for (int i = 0; i < gas.length; ++i) {
            total += gas[i] - cost[i]; // get the cost, it should always be greater than or equal 0

            // similar to kadane's algorithm
            if (total < 0) {
                total = 0; // make it zero
                index = i + 1; // assume next index is the correct answer
            }

            // do summation for both gas and cost
            gSum += gas[i]; 
            cSum += cost[i];
        }

        // if cost > gas at the end, return -1 else return the index result
        return cSum > gSum ? -1 : index;
    }
}