class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i]) > k){
                map.put(nums[start],map.get(nums[start]).intValue() -1);
                start++;
            }
            ans = Math.max(ans,i+1-start);
        }
        return ans;
    }
}