/* Recursion + Memoization */

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int x: nums){
            total += x;
        }
        if(total - target <0 || (total-target)%2 ==1 ){
            return 0;
        }
        int aim = (total-target)/2;
        int[][] dp = new int[n][aim+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,aim,nums,dp);
    }

    public int f(int ind,int target, int[] arr,int[][] dp){
        if(ind == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            if(target == 0 || target == arr[0]){
                return 1;
            }
            return 0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not = f(ind -1,target,arr,dp);
        int take = 0;
        if(arr[ind] <= target){
            take = f(ind-1,target-arr[ind],arr,dp);
        }
        return dp[ind][target] = not+take;
    }
}