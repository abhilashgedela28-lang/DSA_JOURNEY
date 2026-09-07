class Solution {
    public int numDistinct(String s, String t) {
        String str = "";
        
        int[][] dp = new int[s.length()][t.length()];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        int ans = f(0,0,s,t,dp);
        return ans;
    }

    public int f(int ind,int j,String s,String t,int[][] dp){
        if(j == t.length()){
            return 1;
        }
        if(ind == s.length()){
            return 0;
        }
        if(dp[ind][j] != -1){
            return dp[ind][j];
        }
        int val = 0;
        int val2 = 0;
        if(t.charAt(j) == s.charAt(ind)){

        val= f(ind+1,j+1,s,t,dp);
        }
       
        val2=  f(ind+1,j,s,t,dp);
        
       
        return dp[ind][j] = val+val2;
    }
}