class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int k = Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high = k;
        int result = k;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int hours = 0;
            for(int i = 0; i < piles.length; ++i) {
                hours += Math.ceil((double) piles[i] / mid);
            }

            if (hours <= h) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;

            
        }

        return result;        
    }
}