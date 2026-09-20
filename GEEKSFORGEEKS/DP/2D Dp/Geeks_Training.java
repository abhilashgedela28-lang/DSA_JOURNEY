// Memoization method using recursion (Top Down Approach)

class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int[][] dp = new int[mat.length][4];
        return recur(mat.length-1,3,mat,dp);
    }
    
    public int recur(int ind, int last, int[][] mat,int[][] dp){
        if(ind == 0){
            int maxi = 0;
            for(int i = 0;i<3;i++){
                if(i != last){
                    maxi = Math.max(maxi,mat[0][i]);
                }
            }
            return maxi;
        }
        if(dp[ind][last] != 0){
            return dp[ind][last];
        }
        int maxi = 0;
        for(int i = 0;i<3;i++){
            if(i != last){
                int score = mat[ind][i]+recur(ind-1,i,mat,dp);
                maxi = Math.max(maxi,score);
            }
        }
        return dp[ind][last] = maxi;
    }
}

/* Tabulation method (Bottom Up Approach) */

class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int[][] dp = new int[mat.length][4];
        
        dp[0][0] = Math.max(mat[0][1],mat[0][2]);
        dp[0][1] = Math.max(mat[0][0],mat[0][2]);
        dp[0][2] = Math.max(mat[0][1],mat[0][0]);
        dp[0][3] = Math.max(mat[0][1],Math.max(mat[0][2],mat[0][0]));
        
        for(int day = 1;day<mat.length;day++){
            for(int task = 0;task<=3;task++){
                for(int i = 0;i<=2;i++){
                    if(i != task){
                        int score = mat[day][i]+dp[day-1][i];
                        dp[day][task] = Math.max(dp[day][task],score);
                    }
                }
            }
        }
        return dp[mat.length-1][3];
        
    } 
}

/* Tabulation with space optimization method (Bottom Up Approach) */

class Solution {
    public int maximumPoints(int mat[][]) {
        // code here
        int[] dp = new int[4];
        
        dp[0] = Math.max(mat[0][1],mat[0][2]);
        dp[1] = Math.max(mat[0][0],mat[0][2]);
        dp[2] = Math.max(mat[0][1],mat[0][0]);
        dp[3] = Math.max(mat[0][1],Math.max(mat[0][2],mat[0][0]));
        
        for(int day = 1;day<mat.length;day++){
            int[] temp = new int[4];
            for(int last = 0;last<=3;last++){
                for(int task = 0;task<=2;task++){
                    if(last != task){
                        int score = mat[day][task]+dp[task];
                        temp[last] = Math.max(temp[last],score);
                    }
                }
            }
            for(int i = 0;i<4;i++){
                dp[i] = temp[i];
            }
        }
        return dp[3];
    }
}