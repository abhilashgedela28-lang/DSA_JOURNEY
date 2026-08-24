class Solution {
    public int pivotIndex(int[] nums) {
        long total = 0;
        for(int i = 0;i<nums.length;i++){
            total+= nums[i];
        }
        long left = 0;
        long right = 0;
        for(int i = 0;i<nums.length;i++){
            right = total - nums[i] - left;
            if(left == right){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}