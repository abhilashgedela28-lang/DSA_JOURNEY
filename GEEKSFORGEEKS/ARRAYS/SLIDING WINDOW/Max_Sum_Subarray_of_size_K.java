class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int ans = 0;
        int sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];
        }
        int i = 0;
        ans = sum;
        for(int j = k;j<arr.length;j++){
            sum -= arr[i];
            sum += arr[j];
            ans = Math.max(ans,sum);
            i++;
        }
        return ans;
    }
}