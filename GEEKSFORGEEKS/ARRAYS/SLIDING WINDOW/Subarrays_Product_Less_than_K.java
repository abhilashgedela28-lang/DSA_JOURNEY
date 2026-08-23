class Solution {
    public int countSubarray(int[] nums, int k) {
        // code here
        int i =0;
        int ans = 0;
        int pro = 1;
        for(int j = 0;j<nums.length;j++){
            pro *= nums[j];
            while(pro >=k && i <= j){
                pro /= nums[i++];
            }
            ans += j-i+1;
        }
        return ans;
    }
}