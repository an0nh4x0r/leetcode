class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] response = new int[3];

        for (var s: triplets) {
            if (s[0] <= target[0] && s[1] <= target[1] && s[2] <= target[2]) {
                response = new int[] {Math.max(s[0], response[0]), Math.max(s[1], response[1]), Math.max(s[2], response[2])};
            }
        }

        return Arrays.equals(target, response);        
    }
}