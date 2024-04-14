class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] r = new int[3];

        for (var s: triplets) {
            if (s[0] <= target[0] && s[1] <= target[1] && s[2] <= target[2]) {
                r = new int[] {Math.max(s[0], r[0]), Math.max(s[1], r[1]), Math.max(s[2], r[2])};
            }
        }

        return Arrays.equals(r, target);        
    }
}