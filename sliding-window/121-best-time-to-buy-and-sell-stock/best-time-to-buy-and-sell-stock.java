class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 0;
        int maxProfit = 0;

        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            } else {
                buy = sell;
            }
            sell += 1;
        }

        return maxProfit;        
    }
}