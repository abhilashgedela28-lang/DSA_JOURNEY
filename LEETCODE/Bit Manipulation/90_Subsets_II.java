class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        int subsets = 1<<n;

        for(int i = 0;i<subsets;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((i & (1<<j)) != 0){
                    list.add(nums[j]);
                }
            }
            Collections.sort(list);
            set.add(list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> a:set){
            ans.add(a);
        }
        return ans;
    }
}