class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return f(n-1,m-1,s,p,dp);
    }

    public boolean f(int i,int j,String s,String p,Boolean[][] dp){
        if(i<0 && j <0){
            return true;
        }
        if(j<0 && i >=0){
            return false;
        }
        if(j >=0 && i <0){
            for(int jj = 0;jj<=j;jj++){
                if(p.charAt(jj) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = f(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = f(i,j-1,s,p,dp) || f(i-1,j,s,p,dp);
        }
        returndp[i][j] = false;
    }
}