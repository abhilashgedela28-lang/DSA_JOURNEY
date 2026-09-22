/* Recursion + Memoization */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            s2 = ch+s2;
        }
        int[][] dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,n-1,s,s2,dp);
    }

    public int f(int i,int j, String s1,String s2,int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+f(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(f(i-1,j,s1,s2,dp),f(i,j-1,s1,s2,dp));
    }
}

/* Tabulation */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            s2 = ch+s2;
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<= n;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

/*space Optimization */

class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = "";
        int n = s.length();
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            s2 = ch+s2;
        }
        int[]dp = new int[n+1];
        for(int i = 1;i<=n;i++){
            int[] temp = new int[n+1];
            for(int j = 1;j<= n;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    temp[j] = 1+dp[j-1];
                }
                else{
                    temp[j] = Math.max(dp[j],temp[j-1]);
                }
            }
            dp = temp.clone();
        }
        return dp[n];
    }
}