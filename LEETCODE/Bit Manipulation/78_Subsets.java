/* Bit manipulation way of finding all the subsets */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int subsets = 1 <<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<subsets;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((i & (1<<j)) > 0){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

/* Recursive relation for finding all the subsets */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recur(0,list,ans,nums);
        return ans;
    }

    public void recur(int ind,List<Integer> list,List<List<Integer>> ans,int[] nums){
        if(ind >= nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[ind]);
        recur(ind+1,list,ans,nums);
        list.remove(list.size()-1);
        recur(ind+1,list,ans,nums);
    }
}