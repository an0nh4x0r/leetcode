class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int hours = 0;

            for (var pile: piles) {
                hours += Math.ceil((double) pile / mid);
            }

            if (hours <= h) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}