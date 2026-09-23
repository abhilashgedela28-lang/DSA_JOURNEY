class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String str = "";
        for(int i = 0;i<n;i++){
            str = s.charAt(i)+str;
        }
        int[][] dp = new int[n+1][n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1) == str.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int ans = dp[n][n];
        return n-ans;
    }
}