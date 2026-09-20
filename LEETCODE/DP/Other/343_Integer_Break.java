/*Recursion + Memoization*/

class Solution {
    public int integerBreak(int n) {
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans = 0;
        for(int i = 1;i<n;i++){
            ans = Math.max(ans,i*f(n-1,n-i,dp));
        }
        return ans;
    }

    public int f(int ind,int n,int[][] dp){
        if(n == 0){
            return 1;
        }
        if(ind == 0){
            return n;
        }
        if(dp[ind][n] != -1){
            return dp[ind][n];
        }
        int not = f(ind-1,n,dp);
        int take = 0;
        int val = ind+1;
        if(n>=val){
            take = val*f(ind,n-val,dp);
        }
        return dp[ind][n] =  Math.max(not,take);
    }

}