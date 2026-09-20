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

/* Tabulation
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length;
        int n = ob[0].length;
        int[][] dp = new int[m][n];
        if(dp[0][0] == 1 || ob[m-1][n-1] == 1){
            return 0;
        }
        for(int i = 0;i<m;i++){
            if(ob[i][0] == 1){
                break;
            }
            else{
                dp[i][0] = 1;
            }
        }
        for(int i = 0;i<n;i++){
            if(ob[0][i] == 1){
                break;
            }
            else{
                dp[0][i] = 1;
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(ob[i-1][j] != 1){
                    dp[i][j] += dp[i-1][j];
                }
                if(ob[i][j-1] != 1){
                    dp[i][j] += dp[i][j-1];
                }
                
            }
        }
        return dp[m-1][n-1];
    }
}