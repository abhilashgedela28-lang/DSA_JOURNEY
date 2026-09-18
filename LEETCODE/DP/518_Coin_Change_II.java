class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ar:dp){
            Arrays.fill(ar,-1);
        }
        return f(n-1,amount,coins,dp);
    }

    public int f(int n,int amount, int[] coins, int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(n == 0){
            if(amount%coins[n] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[n][amount] != -1){
            return dp[n][amount];
        }
        int not = f(n-1,amount,coins,dp);
        int take = 0;
        if(amount >= coins[n]){
            take = f(n,amount-coins[n],coins,dp);
        }
        return dp[n][amount] = take+not;
    }
}