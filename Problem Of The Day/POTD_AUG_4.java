
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int index = 0;
        for(int i = min;i<max;i++){
            if(nums[index] != i){
                ans.add(i);
            }
            else{
                index++;
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
}
