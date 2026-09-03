class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int n = nums1.length;
        boolean isEven = false;
        if(nums1[0] %2 == 0){
            isEven = true;
        }
        int prev = 0;
        for(int i = 0;i<n;i++){
            if(nums1[i] %2 != 0){
                prev = nums1[i];
                break;
            }
        }
        for(int i = 1;i<nums1.length;i++){
            if(isEven && nums1[i] %2 != 0){
                if((nums1[i] - prev) <1){
                    return false;
                }
            }
            if(!(isEven) && nums1[i]%2 == 0){
                if(nums1[i] - prev < 1){
                    return false;
                }
            }
        }
        return true;
    }
}