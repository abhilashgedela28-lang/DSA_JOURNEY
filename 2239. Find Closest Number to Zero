// code in java

class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = 1000000;
        for(int i = 0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(val == Math.abs(ans)){
                ans = Math.max(nums[i],ans);
            }
            else if(Math.abs(ans) > val){
                ans = nums[i];
            }
        }
        return ans;
    }
}
