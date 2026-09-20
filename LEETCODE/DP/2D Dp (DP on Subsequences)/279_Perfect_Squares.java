class Solution {
    public int numSquares(int n) {
        int num =(int) Math.sqrt(n);
        int[][] dp = new int[num+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return f(num,n,dp);
    }

    public int f(int n,int sum,int[][] dp){
        if(n == 1){
            return sum;
        }
        if(dp[n][sum]!= -1){
            return dp[n][sum];
        }
        int not = f(n-1,sum,dp);
        int take  = Integer.MAX_VALUE;
        if(sum >= n*n){
            take = 1+ f(n,sum-n*n,dp);
        }

        return dp[n][sum] = Math.min(not,take);
    }
}