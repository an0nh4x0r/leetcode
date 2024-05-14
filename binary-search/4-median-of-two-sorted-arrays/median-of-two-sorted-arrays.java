class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = m;
        int half = (m + n + 1) / 2;

        while (left <= right) {
            int partition1 = (left + right) >>> 1;
            int partition2 = half - partition1;

            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m+n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2d;
                } 
                else return Math.max(left1, left2);
            } else if (left1 > right2) right = partition1 - 1;
            else left = partition1 + 1;
        }

        return 0.0;
    }
}