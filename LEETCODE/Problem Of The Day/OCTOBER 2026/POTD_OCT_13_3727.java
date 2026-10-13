class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        for(int i = 0;i<n;i++){
            if(nums[i] <0){
                nums[i]*= -1;
            }
        }
        Arrays.sort(nums);
        long ans = 0;

        for(int i = 0;i<n;i++){
            if(i < n/2){
                ans-= nums[i]*nums[i];
            }
            else{
                ans += nums[i]*nums[i];
            }
        }
        return ans;
    }
}