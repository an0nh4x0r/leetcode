class Solution {
    public int maxProfit(int[] prices) {
        int left = 0; // start of the sliding window
        int right = 0; // end of the sliding window
        int res = 0; // final result

        // standard sliding window template
        while (right < prices.length) {

            // check if the price at the start of sliding window is less than the end of sliding window
            // means we buy on low in past and sell on high in future
            // which is the ideal condition to maximise the profit
            if (prices[left] < prices[right]) {
                // calculate the profit
                int profit = prices[right] - prices[left];
                // assign it to final result, if the profit is higher than last result
                res = Math.max(res, profit); 
            } else {
                // this is the invalid case, and we can't make any profit here
                // so we make the length of sliding window as 1, i.e. by making left = right
                // i.e. incrementing left to the positon of right
                // this also means in future we are getting lower price, 
                // so we move the left pointer to the lower price
                left = right;
            }

            right += 1;
        }

        return res;        
    }
}