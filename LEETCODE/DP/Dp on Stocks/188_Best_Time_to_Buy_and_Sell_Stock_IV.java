/* Recursion + Memoization */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] arr:dp){
            for(int[] ar:arr){
                Arrays.fill(ar,-1);
            }
        }
        return f(0,1,k,prices,dp);
    }

    public int f(int ind,int buy,int cap,int[] prices,int[][][] dp){
        if(ind == prices.length || cap == 0){
            return 0;
        }
        if(dp[ind][buy][cap]!= -1){
            return dp[ind][buy][cap];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind]+f(ind+1,0,cap,prices,dp),
            f(ind+1,1,cap,prices,dp));
        }
        else{
            profit = Math.max(prices[ind]+f(ind+1,1,cap-1,prices,dp),
            f(ind+1,0,cap,prices,dp));
        }
        return dp[ind][buy][cap] = profit;
    }
}


/* Tabulation */
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int ind = n-1;ind >=0;ind--){
            for(int buy = 0;buy <= 1;buy++){
                for(int cap = 1;cap<= k;cap++){
                    int profit = 0;
                    if(buy == 1){
                        dp[ind][buy][cap] = Math.max(-prices[ind]+dp[ind+1][0][cap],dp[ind+1][1][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(prices[ind]+dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}