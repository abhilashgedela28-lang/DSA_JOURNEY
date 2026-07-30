// 3014

class Solution {
    public int minimumPushes(String word) {
        int[] arr = {1,2,3,4};
        int len = word.length();
        int ans = 0;
        int count = 0;
        while(len > 0){
            if(len >= 8){
                ans += arr[count++] * 8;
            }
            else{
                ans += arr[count++] * len;
            }
            len = len- 8;
        }
        return ans;
    }
}
