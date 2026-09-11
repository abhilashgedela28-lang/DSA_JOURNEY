class Solution {
    public int totalNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = 0;j<n;j++){
                if(i == j){
                    continue;
                }
                for(int k = 0;k<n;k++){
                    if(j == k || (i == j && j == k) || i == k){
                        continue;
                    }
                    int val = nums[i]*100+nums[j]*10+nums[k];
                    if(val%2 == 0){
                        set.add(val);
                    }
                }
            }
        }
        return set.size();
    }
}