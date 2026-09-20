/*Recursion + Memoization
Time Complexity: O(N*W) where N is the number of items and W is the capacity of the knapsack.
Auxiliary Space: O(N*W) + O(W) where N is the number of items and W is the capacity of the knapsack. O(N*W) for the dp array and O(W) for the recursion stack space.
*/

class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,capacity,val,wt,dp);
    }
    
    public int f(int ind,int w,int[] val,int[] wt,int[][] dp){
        if(w == 0){
            return 0;
        }
        if(ind == 0){
            return (w/wt[0])*val[0];
        }
        if(dp[ind][w] != -1){
            return dp[ind][w];
        }
        
        int not = f(ind-1,w,val,wt,dp);
        int take = 0;
        if(w >= wt[ind]){
            take = val[ind]+f(ind,w-wt[ind],val,wt,dp);
        }
        return dp[ind][w] = Math.max(not,take);
    }
}

/* Tabulation
Time Complexity: O(N*W) where N is the number of items and W is the capacity of the knapsack.
Auxiliary Space: O(N*W) where N is the number of items and W is the capacity of the knapsack. O(N*W) for the dp array.
*/

class Solution {
    public int knapSack(int val[], int wt[], int c) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][c+1];
        for(int i = 0;i<=c;i++){
            if(i >= wt[0]){
                dp[0][i] = (i/wt[0])*val[0];
            }
        }
        for(int i = 1;i<n;i++){
            for(int cap = 0;cap<=c;cap++){
                int not = dp[i-1][cap];
                int take = 0;
                if(cap >= wt[i]){
                    take = val[i]+dp[i][cap-wt[i]];
                }
                dp[i][cap] = Math.max(not,take);
            }
        }
        return dp[n-1][c];
    }
}

/* Space Optimization */

class Solution {
    public int knapSack(int val[], int wt[], int c) {
        
        int n = val.length;
        int[] dp = new int[c+1];
        for(int i = 0;i<=c;i++){
            if(i >= wt[0]){
                dp[i] = (i/wt[0])*val[0];
            }
        }
        for(int i = 1;i<n;i++){
            int[] temp = new int[c+1];
            for(int cap = 0;cap<=c;cap++){
                int not = dp[cap];
                int take = 0;
                if(cap >= wt[i]){
                    take = val[i]+temp[cap-wt[i]];
                }
                temp[cap] = Math.max(not,take);
            }
            dp = temp.clone();
        }
        return dp[c];
    }
}