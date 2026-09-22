class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int atotal = 0;
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            atotal += (int) s1.charAt(i-1);
            for(int j=1;j<=m;j++){
                if(i == 1){
                    atotal += (int) s2.charAt(j-1);
                }
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=(int)s1.charAt(i-1)+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return atotal - 2*dp[n][m];
    }
}