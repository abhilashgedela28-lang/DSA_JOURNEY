class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for(long[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(0,1,nums,dp);
    }

    public long f(int i,int sign,int[] nums,long[][] dp){
        if(i >= nums.length ){
            return 0;
        }
        if(dp[i][sign] != -1){
            return dp[i][sign];
        }
        long skip = f(i+1,sign,nums,dp);

        long take = 0;
        if(sign == 1){
            take = nums[i]+f(i+1,0,nums,dp);
        }
        else{
            take = -nums[i]+f(i+1,1,nums,dp);
        }
        return dp[i][sign] = Math.max(take,skip);
    }
}