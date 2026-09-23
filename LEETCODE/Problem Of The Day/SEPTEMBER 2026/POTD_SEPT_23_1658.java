class Solution {
    public int minOperations(int[] nums, int x) {
        long total = 0;
        int n = nums.length;
        for(int a:nums){
            total += a;
        }
        int i = 0;
        long sum = 0;
        if(total == x){
            return n;
        }
        int ans = n+2;
        for(int j = 0;j<n;j++){
            sum += nums[j];
            while(i<j && (total - sum) < x){
                sum -= nums[i];
                i++;
            }
            if(total - sum == x){
                ans = Math.min(ans,n - (j-i+1));
            }
            if(sum == x){
                ans = Math.min(ans,j-i+1);
            }
        }
        if(ans == n+2){
            return -1;
        }
        return ans;
    }
}