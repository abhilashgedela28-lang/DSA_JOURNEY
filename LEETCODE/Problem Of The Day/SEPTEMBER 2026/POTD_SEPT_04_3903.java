class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = -1;
        for(int i = 0;i<nums.length;i++){
            int min = f(i,nums);
            if(max < nums[i]){
                max = nums[i];
            }
            int dif = max - min;
            if(dif <= k){
                return i;
            }
        }
        return -1;
    }

    public int f(int i , int[] nums){
        int min = Integer.MAX_VALUE;
        for(int j = i;j<nums.length;j++){
            min = Math.min(min,nums[j]);
        }
        return min;
    }
}