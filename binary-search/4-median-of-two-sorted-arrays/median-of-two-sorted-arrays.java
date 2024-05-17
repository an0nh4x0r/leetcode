class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = m;
        int half = (m + n + 1) / 2;

        double result = 0.0;

        while (low <= high) {
            int partA = (low + high) >>> 1;
            int partB = half - partA;

            int left1 = (partA == 0) ? Integer.MIN_VALUE : nums1[partA - 1];
            int right1 = (partA == m) ? Integer.MAX_VALUE : nums1[partA];
            int left2 = (partB == 0) ? Integer.MIN_VALUE : nums2[partB - 1];
            int right2 = (partB == n) ? Integer.MAX_VALUE : nums2[partB];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2d;
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            } else if (left1 > right2) high = partA - 1;
            else low = partA + 1;
        }

        return result;
    }
}