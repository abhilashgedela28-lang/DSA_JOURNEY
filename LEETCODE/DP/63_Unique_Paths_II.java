/* Recursion + Memoization 
    Time Complexity: O(m*n)
    Space Complexity: O(m*n) + O(m+n)
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length;
        int n = ob[0].length;
        int[][] dp = new int[m][n];
        if((n*m == 1 && ob[0][0] == 1)||(ob[0][0] == 1)){
            return 0;
        }
        return f(m-1,n-1,dp,ob);
    }

    public int f(int i,int j,int[][] dp,int[][] ob){
        if(i == 0 && j == 0){
            return 1;
        }
        if((i<0 || j < 0)||(ob[i][j] == 1)){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int up = f(i-1,j,dp,ob);
        int left = f(i,j-1,dp,ob);
        return dp[i][j] = up+left;
    }
}