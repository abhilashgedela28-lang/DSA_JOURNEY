class Solution {
    public int missingMultiple(int[] nums, int k) {
        int min = k;
        Arrays.sort(nums);
        for(int x: nums){
           if(min == x){
            min = min+k;
           }
        }
        return min;
    }
}