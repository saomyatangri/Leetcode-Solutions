class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];
            if (currPrice < lowestPrice) {
                lowestPrice = currPrice;
            }
            if (currPrice - lowestPrice > maxProfit) {
                maxProfit = currPrice - lowestPrice;
            }
        }
        return maxProfit;
    }
}
