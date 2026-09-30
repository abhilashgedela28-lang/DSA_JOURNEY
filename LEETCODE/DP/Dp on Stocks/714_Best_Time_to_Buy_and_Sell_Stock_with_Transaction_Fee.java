class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(0,1,prices,dp,fee);
    }

    public int f(int ind,int buy,int[] prices,int[][] dp,int fee){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind]+f(ind+1,0,prices,dp,fee),
            f(ind+1,1,prices,dp,fee));
        }
        else{
            profit = Math.max(prices[ind] - fee+f(ind+1,1,prices,dp,fee),
            f(ind+1,0,prices,dp,fee));
        }
        return dp[ind][buy] = profit;
    }
}