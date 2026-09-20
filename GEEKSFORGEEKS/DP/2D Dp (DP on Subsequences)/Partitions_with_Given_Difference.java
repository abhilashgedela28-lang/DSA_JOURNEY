/* Recursion + Memoization */
class Solution {
    int mod = (int)(1e9+7);
    public int countPartitions(int[] arr, int diff) {
        // code here
        
        int total = 0;
        for(int x: arr){
            total += x;
        }
        if(total - diff < 0 || (total-diff)%2 == 1){
            return 0;
        }
        int target = (total-diff)/2;
        int[][] dp = new int[arr.length][target+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return f(arr.length-1,target,arr,dp);
    }
    
    public int f(int ind, int sum, int[] arr,int[][] dp){
        if (ind == 0) {

            if (sum == 0 && arr[0] == 0) {
                return 2;
            }

            if (sum == 0 || arr[0] == sum) {
                return 1;
            }
            return 0;
        }
        if(dp[ind][sum] != -1){
            return dp[ind][sum];
        }
        int not = f(ind-1,sum,arr,dp);
        int pick =0;
        if(arr[ind] <= sum){
            pick = f(ind-1,sum-arr[ind],arr,dp);
        }
        return dp[ind][sum] = ((pick)%mod+(not)%mod)%mod;
    }
}

/* tabulation */

class Solution {
    int mod = (int)(1e9+7);
    public int countPartitions(int[] nums, int diff) {
        // code here
        int total = 0;
        for(int x: nums){
            total += x;
        }
        if(total - diff < 0 || (total-diff)%2 == 1){
            return 0;
        }
        int target = (total-diff)/2;
        int[][] dp = new int[nums.length][target+1];
        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }
        if(nums[0]!= 0 && nums[0] <= target)
        {
            dp[0][nums[0]] = 1;
        }
        for(int i = 1;i < nums.length;i++){
            for(int sum = 0;sum<=target;sum++){
                int not = dp[i-1][sum];
                int take = 0;
                if(nums[i] <= sum){
                    take = dp[i-1][sum-nums[i]];
                }
                dp[i][sum] = ((take%mod)+(not%mod))%mod;
            }
        }
        return dp[nums.length-1][target];
    }
}

