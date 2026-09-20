/*  Recursion + Memoization
    Time Complexity: O(n^2)
    Space Complexity: O(n^2)+ O(n) for recursion stack
*/


class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int n = grid.length;

        int[][] dp = new int[n+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr,10000);
        }

        for(int i = 0;i<n;i++){
            int val = f(n-1,n,grid,dp);
            ans = Math.min(val,ans);
        }
        return ans;
    }

    public int f(int n, int last, int[][] grid,int[][] dp){

        if(n == 0){
            int min = Integer.MAX_VALUE;
            for(int i = 0;i<grid.length;i++){
                if(i != last){
                    min = Math.min(min,grid[0][i]);
                }
            }
            return min;
        }

        if(dp[n][last]!= 10000){
            return dp[n][last];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0;i<grid.length;i++){
            if(i != last){
                int val = grid[n][i] + f(n-1,i,grid,dp);
                min = Math.min(val,min);
            }
        }
        
        return dp[n][last] = min;
    }
}