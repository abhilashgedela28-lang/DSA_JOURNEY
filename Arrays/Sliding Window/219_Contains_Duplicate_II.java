class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                int ind = map.get(nums[i]);
                if(i - ind <= k){
                    return true;
                }
            }
            map.put(nums[i],i);
            set.add(nums[i]);
        }
        return false;
    }
}