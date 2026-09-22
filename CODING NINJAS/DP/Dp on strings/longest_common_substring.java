public class Solution {
    public static int lcs(String str1, String str2){
        // Write your code here.
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
