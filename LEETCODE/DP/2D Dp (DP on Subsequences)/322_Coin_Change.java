/* Recursion + Memoization */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans =  f(n-1,amount,coins,dp);
        if(ans == (int)1e9){
            return -1;
        }
        return ans;
    }

    public int f(int ind, int target, int[] arr, int[][] dp){
        if(ind == 0){
            if(target%arr[ind] == 0){
                return target/arr[ind];
            }
            return (int) 1e9;
        }

        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not = f(ind-1,target,arr,dp);
        int take = (int) 1e9;
        if(target >= arr[ind]){
            take = 1+f(ind,target-arr[ind],arr,dp);
        }
        return dp[ind][target] = Math.min(take,not);
    }
}
/* tabulation */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i= 0;i<= amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
            else{
                dp[0][i] = (int) 1e9;
            }
        }
        for(int i = 1;i<n;i++){
            for(int t= 0;t<= amount;t++){
                int not = dp[i-1][t];
                int take = (int) 1e9;
                if(t >= coins[i]){
                    take = 1+ dp[i][t-coins[i]];
                }
                dp[i][t] = Math.min(not,take);
            }
        }
        if(dp[n-1][amount] == (int)1e9){
            return -1;
        }
        return dp[n-1][amount];
    }
}

