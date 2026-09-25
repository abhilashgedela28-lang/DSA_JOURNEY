class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,-1,nums,dp);
        
    }

    public int f(int ind,int prev,int[] nums,int[][] dp){
        if(ind < 0){
          return 0;
        }
        if(dp[ind][prev+1] != -1){
            return dp[ind][prev+1];
        }

        int take = 0;
        if(prev == -1 ||nums[ind] < nums[prev]){
            take = 1 + f(ind-1,ind,nums,dp);
        }
        int not = f(ind-1,prev,nums,dp);

        return dp[ind][prev+1] =  Math.max(take,not);
    }
}