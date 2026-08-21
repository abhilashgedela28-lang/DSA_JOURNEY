

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        int j = 0;
        for(int i = 0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            sum+= nums[i];
        }
        if(k == map.size()){
            ans = sum;
        }
        for(int i = k;i<nums.length;i++){
            sum -= nums[j];
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[j]).intValue() == 1){
                map.remove(nums[j]);
            }
            else{
                map.put(nums[j],map.get(nums[j]).intValue()-1);
            }
            if(map.size() == k){
                ans = Math.max(ans,sum);
            }
            j++;
        }
        return ans;
    }
}