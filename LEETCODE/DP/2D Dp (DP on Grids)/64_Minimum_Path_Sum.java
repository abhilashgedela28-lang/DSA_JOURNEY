/* Recursion + Memoization 
    Time Complexity: O(m*n)
    Space Complexity: O(m*n) + O(m+n) (for recursion stack)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return f(m-1,n-1,grid,dp);
    }

    public int f(int m, int n,int[][] grid,int[][] dp){
        if(m == 0 && n == 0){
            return grid[0][0];
        }
        if(m < 0 || n < 0){
            return 1000000;
        }
        if(dp[m][n] != 0){
            return dp[m][n];
        }
        int up = grid[m][n] +f(m-1,n,grid,dp);
        int left = grid[m][n] + f(m,n-1,grid,dp);
        return dp[m][n] = Math.min(up,left); 
    }
}

/* Tabulation 
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] dp = new long[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }
                else if(j == 0){
                    dp[i][j] = grid[i][j]+ dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return (int) dp[m-1][n-1];
    }
}