class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new LinkedHashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int index = 0;
        for(int x: map.keySet()){
            if(map.get(x) >= 2){
                for(int i = 0;i<2;i++){
                    nums[index++] = x;
                }
            }
            else{
                nums[index++] = x;
            }
        }
        return index;       
    }
}