class Solution {
    public int countGoodRotations(int[] nums) {
        int ans = 0;
        long left = 0;
        long right = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(i < n/2){
                left += nums[i];
            }
            else{
                right += nums[i];
            }
        }
        int j = n/2;
        for(int i = 0;i<n;i++){
        System.out.println(left+" "+right);
            if(j >= n){
                j = 0;
            }
            left -= nums[i];
            left += nums[j];
            right -= nums[j];
            right += nums[i];
            if(left > right){
                ans++;
            }
            j++;
        }
        System.out.println(left+" "+right);
        return ans;
    }
}