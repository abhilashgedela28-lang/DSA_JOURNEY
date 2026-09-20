/* Recursion + Memoization */
class Solution {
    public int knapsack(int w, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][w+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,w,val,wt,dp);
        
    }
    
    public int f(int n,int w,int[] val,int[] wt,int[][] dp){
        if(w == 0){
            return 0;
        }
        if(n == 0){
            if(w >= wt[0]) return val[0];
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }
        int not = f(n-1,w,val,wt,dp);
        int pick = (int)-1e8;
        if(w >= wt[n]){
            pick = val[n]+f(n-1,w-wt[n],val,wt,dp);
        }
        return dp[n][w] = Math.max(pick,not);
    }
}

/* tabulaton */
class Solution {
    public int knapsack(int w, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n][w+1];
        for(int i = wt[0];i<=w;i++){
            dp[0][i] = val[0];
        }
        for(int i = 1;i<n;i++){
            for(int we = 0;we <= w;we++){
                int not = dp[i-1][we];
                int pick = (int)-1e8;
                if(we >= wt[i]){
                    pick = dp[i-1][we-wt[i]]+val[i];
                }
                dp[i][we] = Math.max(pick,not); 
            }
        }
        return dp[n-1][w];
    }
}

