class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int hour = 0;
            for (int pile: piles) {
                hour += Math.ceil((double) pile / mid);
            }

            if (hour <= h) {
                res = Math.min(res, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }
}