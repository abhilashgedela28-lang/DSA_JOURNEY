/* Recursion + Memoization 
    Time Complexity: O(n^2)O(N2)
    Space Complexity: O(n^2)+O(n^2)O(N2)+O(N2) (dp array + recursion stack)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] arr: dp){
            Arrays.fill(arr,100000);
        }
        return f(0,0,triangle,dp);
    }

    public int f(int n,int i,List<List<Integer>> list, int[][] dp){
        if(n == list.size() -1){
            return list.get(n).get(i);
        }
        if(dp[n][i] != 100000){
            return dp[n][i];
        }
        int down = list.get(n).get(i)+f(n+1,i,list,dp);
        int right = list.get(n).get(i)+f(n+1,i+1,list,dp);
        dp[n][i] = Math.min(down,right);
        return dp[n][i];
    }
}

/* Tabulation
    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[n-1][i] = list.get(n-1).get(i);
        }
        for(int i = n-2;i>=0 ;i--){
            for(int j = i;j>=0 ;j--){
                int down = list.get(i).get(j)+dp[i+1][j];
                int right = list.get(i).get(j)+dp[i+1][j+1];
                dp[i][j] = Math.min(down,right);
            }
        }
        return dp[0][0];
    }
}

/* Space Optimization
    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        int[] dp = new int[n];
        for(int i = 0;i<n;i++){
            dp[i] = list.get(n-1).get(i);
        }
        for(int i = n-2;i>=0 ;i--){
            int[] temp = new int[n];
            for(int j = i;j>=0 ;j--){
                int down = list.get(i).get(j)+dp[j];
                int right = list.get(i).get(j)+dp[j+1];
                temp[j] = Math.min(down,right);
            }
            dp = temp.clone();
        }
        return dp[0];
    }
}

