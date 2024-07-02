class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        long sum1 = 0;
        long sum2 = 0;

        int i = 0;
        int j = 0;

        while (i < n1 || j < n2) {
            if (i < n1 && (j == n2 || nums1[i] < nums2[j])) {
                sum1 += nums1[i];
                i++;
            } else if (j < n2 && (i == n1 || nums2[j] < nums1[i])) {
                sum2 += nums2[j];
                j++;
            } else {
                sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                i++;
                j++;
            }
        }

        return (int) (Math.max(sum1, sum2) % MOD);
    }
}