class Solution {
    public int[] singleNumber(int[] nums) {

        int total = 0;
        int n = nums.length;

        for(int x:nums){
            total ^= x;
        }

        int bit = (total & -total);
        int group1 = 0;
        int group2 = 0;

        for(int x:nums){
            if((x&bit)!=0){
                group1 ^= x;
            }
            else{
                group2 ^= x;
            }
        }

        int[] ans = new int[2];
        ans[0] = group1;
        ans[1] = group2;

        return ans;
    }
}