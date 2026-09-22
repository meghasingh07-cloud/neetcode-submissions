class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int n=prices.length;
        int profit=0;
        for(int i=0; i<n;i++){
            int cost=prices[i]-mini;
            profit=Math.max(cost, profit);
            mini=Math.min(mini, prices[i]);
        }
        return profit;
    }
}
