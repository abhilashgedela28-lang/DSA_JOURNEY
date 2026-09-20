/* Recursion + Memoization 
    Time Complexity: O(m*n)
    Space Complexity: O(m*n) + O(m+n)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return f(m-1,n-1,dp);
    }

    public int f(int i,int j,int[][] dp){
        if(i == 0 && j == 0){
            return 1;
        }
        if( i <0 || j <0){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int up = f(i-1,j,dp);
        int left = f(i,j-1,dp);
        return dp[i][j] = up+left;
    }
}

/* Tabulation 
    time Complexity: O(m*n)
    Space Complexity: O(m*n)
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if( i == 0){
                    ans[i][j] = 1;
                }
                else if(j == 0){
                    ans[i][j] = 1;
                }
                else{
                    ans[i][j] = ans[i-1][j]+ans[i][j-1];
                }
            }
        }
        return ans[m-1][n-1];
    }
}

/* Tabulation + Space Optimization
    Time Complexity: O(m*n)
    Space Complexity: O(n)
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0;i<m;i++){
            int[] temp = new int[n];
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0){
                    temp[j] = 1;
                }
                else{
                    temp[j] = dp[j]+temp[j-1];
                }
            }
            dp = temp.clone();
        }
        return dp[n-1];
    }
}