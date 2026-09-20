/* recursion + memoization */
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int x:nums){
            total += x;
        }
        Boolean[][] dp = new Boolean[nums.length][(total/2)+1];
        if(total %2 ==0){
            return f(nums.length-1,total/2,nums,dp);
        }
        return false;
        
    }

    public boolean f(int n, int target,int[] nums,Boolean[][] dp){
        if(target == 0){
            return true;
        }
        if(n == 0){
            if(nums[0] == target){
                return true;
            }
            return false;
        }
        if(dp[n][target] != null){
            return dp[n][target];
        }
        boolean not = f(n-1,target,nums,dp);
        boolean take = false;
        if(nums[n] <= target){
            take = f(n-1,target-nums[n],nums,dp);
        }
        return dp[n][target] = take||not;
    }
}