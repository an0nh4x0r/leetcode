class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (canEatInTime(piles, mid, h)) high = mid - 1;
            else low = mid + 1;   
        }

        return low;        
    }

    public boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile: piles) {
            double div = Math.ceil((double)pile / k);
            hours += div;
        }

        return hours <= h;
    }
}