class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int ksub = sub(nums,k);
        int lksub = sub(nums,k-1);
        return ksub - lksub;
        
    }

    public int sub(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size() > k){
                if(map.get(nums[i]).intValue() == 1){
                    map.remove(nums[i]);
                }
                else{
                    map.put(nums[i],map.get(nums[i]).intValue()-1);
                }
                i++;
            } 
            ans += j -i +1;
        }
        return ans;
    }
}