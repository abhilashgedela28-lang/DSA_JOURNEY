// Seive Erasthos algorithm

class Solution {
    int unvisitedLeaves(int arr[], int k) {
        // code here
        int[] a = new int[k+1];
        a[0] = 1;
        for(int x:arr){
            for(int i = x;i <= k;i += x){
                a[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 0;i<=k;i++){
            if(a[i] == 0){
                ans++;
            }
        }
        return ans;
    }
}