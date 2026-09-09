/* Tabulation helps in solving the problem in O(n*sum) time complexity and O(n*sum) space complexity. The idea is to find all the possible sums that can be formed using the elements of the array. Then, we can find the minimum difference between two subsets by checking the possible sums.
We can use a 2D boolean array dp[n][sum+1] where dp[i][j] will be true if we can form the sum j using the first i elements of the array. We initialize the first column of the dp array to true because we can always form the sum 0 by not including any elements. We also initialize the first row of the dp array based on whether the first element can form a particular sum or not.
Then, we fill the dp array using the following recurrence relation: */

class Solution {
    public int minDifference(int arr[]) {
        
        int sum = 0;
        for(int x: arr){
            sum += x;
        }
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<= sum;j++){
                boolean not = dp[i-1][j];
                boolean take = false;
                if(j >= arr[i]){
                    take = dp[i-1][j - arr[i]];
                }
                dp[i][j] = take || not;
            }
        }
        
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<sum;i++){
            if(dp[n-1][i]){
                int s1 = i;
                int s2 = sum - i;
                mini = Math.min(mini,Math.abs(s1-s2));
            }
        }
        return mini;
    }
}
