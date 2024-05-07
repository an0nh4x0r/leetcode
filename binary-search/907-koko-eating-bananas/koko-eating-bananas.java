class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (canEatBananas(piles, mid, h)) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public boolean canEatBananas(int[] piles, int k, int h) {
        double hours = 0;
        for (int pile: piles) {
            hours += Math.ceil(Double.valueOf(pile) / Double.valueOf(k)); 
        }
        return hours <= h;
    }
}