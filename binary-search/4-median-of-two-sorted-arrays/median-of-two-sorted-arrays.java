class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n)
            return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = m, halfLength = (m + n + 1) / 2;
        var result = 0.0;

        while (left <= right) {
            int partitionA = (left + right) >>> 1;
            int partitionB = halfLength - partitionA;

            int maxX = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minX = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int maxY = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minY = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    result = (Math.max(maxX, maxY) + Math.min(minY, minX)) / 2d;
                } else {
                    result = Math.max(maxX, maxY);
                }
                break;
            } else if (maxX > minY) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }

        return result;
    }
}