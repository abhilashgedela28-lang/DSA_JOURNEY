class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n== 1){
            return 1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxi =  -1;
        int mini = -1;
        for(int i = 0;i<n;i++){
            if(nums[i] > max){
                max = nums[i];
                maxi = i;
            }
            if(nums[i]<min){
                min = nums[i];
                mini = i;
            }
        }
        int front = Math.max(mini,maxi) + 1;
        int back = n - Math.min(mini,maxi);
        int l = mini+1 + (n-maxi);
        int r = maxi+1 + (n-mini);
        return Math.min(Math.min(front,back),Math.min(l,r));
    }
}