// Brute Force solution

class Solution {
    public int minDays(int n) {
        int[] dp = new int[n*2];
        Arrays.fill(dp,-1);
        return f(0,0,1,n,dp);
    }

    public int f(int n,int sum,int streak,int goal,int[] dp){
        if(sum == goal){
            return n;
        }
        if(n>goal*2){
            return 1000000;
        }
        if(sum > goal){
            return 1000000;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int take = f(n+1,sum+streak,streak+1,goal,dp);
        int not = f(n+1,sum,1,goal,dp);
        return dp[n] = Math.min(take,not);
    }
}©leetcode