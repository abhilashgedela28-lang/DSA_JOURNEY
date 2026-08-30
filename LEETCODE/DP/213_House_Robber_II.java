class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int ans1 = find(0,nums.length-1,nums);
        int ans2 = find(1,nums.length,nums);
        return Math.max(ans1,ans2);
    }

    public int find(int start ,int end,int[] nums){
        int prev2 = 0;
        int prev = 0;
        for(int i = start;i<end;i++){
            int curr = Math.max(prev,prev2+nums[i]);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}