/*Recursion + Memoization*/

class Solution {
    int mod = (int)1e9+7;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n,x,dp,n);
    }

    public int f(int n,int x,int[][] dp,int sum){
        if(n == 1){
            if(sum == 0 || sum == (int) Math.pow(n,x)){
                return 1;
            }
            return 0;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        int not = f(n-1,x,dp,sum);
        int val =(int) Math.pow(n,x);
        int take = 0;
        if(sum >= val){
            take = f(n-1,x,dp,sum-val);
        }
        return dp[n][sum] = ((take%mod)+(not%mod))%mod;
    }
}