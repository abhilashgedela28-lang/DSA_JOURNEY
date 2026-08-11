class Solution {
    public int missingInteger(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            list.add(nums[i]);
        }
        int pre = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                pre += nums[i];
            }
            else{
                break;
            }
        }
        while(list.contains(pre)){
            pre++;
        }
        return pre;
    }
}