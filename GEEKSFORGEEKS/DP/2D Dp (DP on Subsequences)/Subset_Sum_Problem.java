/* Recursion + Memoization 
    Time Complexity: O(n*sum)
    Space Complexity: O(n*sum) + O(n) (for recursion stack)
*/

class Solution {
    static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[][] dp = new int[arr.length][sum+1];
        for(int[] ar: dp){
            Arrays.fill(ar,-1);
        }
        int val = f(arr.length-1,sum,dp,arr);
        if(val == 1){
            return true;
        }
        return false;
    }
    
    static int f(int ind,int target,int[][] dp, int[] arr){
        if(target == 0){
            return 1;
        }
        if(ind == 0){
            if(arr[0] == target){
                return 1;
            }
            return 0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int not_take = f(ind-1,target,dp,arr);
        int take = -1;
        if(target >= arr[ind]){
            take = f(ind-1,target-arr[ind],dp,arr);
        }
        if(take == 1 || not_take == 1){
            dp[ind][target] = 1;
        }
        else{
            dp[ind][target]  = 0;
        }
        
        return dp[ind][target];
    }
}