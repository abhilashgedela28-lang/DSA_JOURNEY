import java.util.*;
class Solution {
    int minCost(int[] heights) {
        // code here
        int[] dp = new int[heights.length+1];
        return recur(heights,dp,heights.length-1);
        
    }
    int recur(int[] heights, int[] dp, int n){
        if(n == 0){
            return 0;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int left = recur(heights,dp,n-1)+ Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = recur(heights,dp,n-2)+Math.abs(heights[n] - heights[n
            -2]);
        }
        return dp[n] = Math.min(right,left);
    }
}