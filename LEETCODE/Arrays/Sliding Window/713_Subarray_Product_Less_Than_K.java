class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int pro = 1;
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            pro *= nums[j];
            while(pro >= k && i < nums.length){
                pro /= nums[i];
                i++;
            }
            ans += j - i+1;
        }
        return ans;
    }
}