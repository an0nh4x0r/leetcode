class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = m;

        int halfLength = (m + n + 1) / 2;
        var result = 0d;

        while (low <= high) {
            int partitionA = (low + high) >>> 1;
            int partitionB = halfLength - partitionA;

            int left1 = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int right1 = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int left2 = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int right2 = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2d;
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            } else if (left1 > right2) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        return result;
    }
}