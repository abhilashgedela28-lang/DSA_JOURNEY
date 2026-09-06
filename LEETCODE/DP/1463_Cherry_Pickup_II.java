/*Recursion + Memoization
    Time Complexity: O(m*n*n)
    Space Complexity: O(m*n*n)
*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] arr:dp){
            for(int[] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return f(0,0,grid[0].length-1,grid,dp);
    }

    public int f(int i,int j1,int j2, int[][] grid, int[][][] dp){
        if(j1 <0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length){
            return -10000000;
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        if( i == grid.length-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            return grid[i][j1]+grid[i][j2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int dj1 = -1;dj1 < 2;dj1++){
            for(int dj2 = -1;dj2 < 2;dj2++){
                if(j1 == j2){
                    maxi = Math.max(maxi,grid[i][j1] + f(i+1,j1+dj1,j2+dj2,grid,dp));
                }
                else{
                    maxi = Math.max(maxi,grid[i][j1]+grid[i][j2] + f(i+1,j1+dj1,j2+dj2,grid,dp));
                }
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}