class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] r = new int[3];

        for (int[] s: triplets) {
            if (s[0] <= target[0] && s[1] <= target[1] && s[2] <= target[2]) {
                r = new int[] {Math.max(r[0], s[0]), Math.max(r[1], s[1]), Math.max(r[2], s[2])};
            }
        }

        return Arrays.equals(target, r);
    }
}