/* Recusrion + Memoization 
    Time Complexity : O(n^2)
    Space Complexity : O(n^2)+O(n) for recursion stack
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int d = matrix.length;
        int[][] dp = new int[d][d];
        for(int i = 0;i<d;i++){
            for(int[] arr: dp){
                Arrays.fill(arr,Integer.MIN_VALUE);
            }
            int val = f(d-1,i,matrix,dp);
            ans = Math.min(ans,val);
        }
        return ans;
    }

    public int f(int n, int i,int[][] matrix,int[][] dp){
        if(i<0 || i >= matrix.length){
            return 100000;
        }
        if(n == 0){
            return matrix[n][i];
        }
        if(dp[n][i] != Integer.MIN_VALUE){
            return dp[n][i];
        }
        int ld = matrix[n][i] + f(n-1,i-1,matrix,dp);
        int d = matrix[n][i] + f(n-1,i,matrix,dp);
        int rd = matrix[n][i] + f(n-1,i+1,matrix,dp);
        return dp[n][i] = Math.min(ld,Math.min(d,rd));
    }
}

/* Tabulation
    Time Complexity : O(n^2)
    Space Complexity : O(n^2)
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1;i<n;i++){
            for(int j = 0;j<n;j++){

                int left = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if( j >0){
                    left = dp[i-1][j-1];
                }

                down = dp[i-1][j];

                if(j < n-1){
                   right =  dp[i-1][j+1];
                }

                dp[i][j] = Math.min(down,Math.min(right,left)) + matrix[i][j];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        
        return ans;
    }
}


/* Tabulation + Space Optimization
    Time Complexity : O(n^2)
    Space Complexity : O(n)
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            dp[i] = matrix[0][i];
        }
        

        for(int i = 1;i<n;i++){
            int[] temp = new int[n];
            for(int j = 0;j<n;j++){
                int left = Integer.MAX_VALUE;
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if( j >0){
                    left = dp[j-1];
                }
                down = dp[j];
                if(j < n-1){
                   right =  dp[j+1];
                }
                temp[j] = Math.min(down,Math.min(right,left)) + matrix[i][j];
            }
            dp = temp.clone();
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            ans = Math.min(ans,dp[i]);
        }
        return ans;
    }
}