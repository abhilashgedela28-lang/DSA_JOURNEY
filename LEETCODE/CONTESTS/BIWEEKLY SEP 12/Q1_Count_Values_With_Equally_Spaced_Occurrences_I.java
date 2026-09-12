class Solution {
    public int countSpecialIntegers(int[] nums) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<101;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<nums.length;i++){
            list.get(nums[i]).add(i);
        }
        int ans = 0;
        for(int i = 0;i<101;i++){
            if(list.get(i).size() == 3){
                int o = list.get(i).get(0);
                int t = list.get(i).get(1);
                int th = list.get(i).get(2);
                if(t - o == th -t){
                    ans++;
                }
            }
        }
        return ans;
    }
}©leetcode