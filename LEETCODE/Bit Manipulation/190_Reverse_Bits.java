class Solution {
    public int reverseBits(int n) {
        int[] arr = new int[32];
        for(int i = 0;i<32;i++){
            if((n & (1<<i)) != 0){
                arr[i] = 1;
            }
        }
        int ans = 0;
        for(int i = 31;i>=0;i--){
            if(arr[i] == 1){    
                ans += (1 <<(31-i));
            }
        }
        return ans;
    }
}