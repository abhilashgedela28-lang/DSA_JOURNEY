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
        // System.out.println(str);
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
        // System.out.println(ind+" "+dp[ind+1][str.length()+1]);
        val2=  f(ind+1,j,s,t,dp);
        // System.out.println(ind+" "+dp[ind+1][str.length()]);
       
        return dp[ind][j] = val+val2;
    }
}