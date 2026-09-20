/*Recursion + Memoization */

class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,n,price,dp);
    }
    
    public int f(int ind,int n,int[] price,int[][] dp){
        if(ind == 0){
            return n*price[0];
        }
        
        if(dp[ind][n]!= -1){
            return dp[ind][n];
        }
        
        int not = f(ind-1,n,price,dp);
        int take = Integer.MIN_VALUE;
        int rod = ind+1;
        
        if(n>= rod){
            take = price[ind]+f(ind,n-rod,price,dp);
        }
        
        return dp[ind][n] = Math.max(not,take);
    }
}

/*Tabulation */
class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0;i<=n;i++){
            dp[0][i] = i*price[0];
        }
        for(int i = 1;i<n;i++){
            for(int t = 0;t<=n;t++){
                int not = dp[i-1][t];
                int take = Integer.MIN_VALUE;
                if(t >= i+1){
                    take = price[i]+dp[i][t-(i+1)];
                }
                dp[i][t] = Math.max(not,take);
            }
        }
        return dp[n-1][n];
    }
}

/*Space Optimization */

class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[] dp = new int[n+1];
        for(int i = 0;i<=n;i++){
            dp[i] = i*price[0];
        }
        for(int i = 1;i<n;i++){
            int[] temp = new int[n+1];
            for(int t = 0;t<=n;t++){
                int not = dp[t];
                int take = Integer.MIN_VALUE;
                if(t >= i+1){
                    take = price[i]+temp[t-(i+1)];
                }
                temp[t] = Math.max(not,take);
            }
            dp = temp.clone();
        }
        return dp[n];
    }
}