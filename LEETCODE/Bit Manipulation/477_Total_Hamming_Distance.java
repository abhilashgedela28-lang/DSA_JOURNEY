class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0;i<32;i++){
            int count = 0;
            for(int x:nums){
                if((x&(1<<i)) != 0){
                    count++;
                }
            }
            if(count != 0 && count != n){
                ans += count*(n-count); 
            }
        }
        return ans;
    }
}