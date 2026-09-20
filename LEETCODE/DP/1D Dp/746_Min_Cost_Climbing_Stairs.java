/* Recursion + Memoization 
    Time Complexity: O(n)
    Space Complexity: O(n) + O(n)
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return recur(cost.length,dp,cost);
    }

    public int recur(int ind, int[] dp, int[] cost){
        if(ind <= 1){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int one = cost[ind-1]+recur(ind-1,dp,cost);
        int two = cost[ind-2] + recur(ind-2,dp,cost);
        return dp[ind] = Math.min(one,two);
    }
}

/*tabulation
    Time Complexity: O(n)
    Space Complexity: O(n)
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i<n;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}

/* Tabulation + Space Optimization 
    Time Complexity: O(n)
    Space Complexity: O(1)
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        if(n == 2){
            return Math.min(prev2,prev1);
        }  
        if(n == 3){
            return Math.min(prev1,prev2+cost[2]);
        } 
        for(int i = 2;i<n;i++){
            int curr = Math.min(prev1,prev2)+cost[i];
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev2);
    }
}