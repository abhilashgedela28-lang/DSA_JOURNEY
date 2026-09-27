class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0;i<32;i++){
            for(int j = 1;j<=n;j++){
                if((j & (1<<i)) != 0){
                    arr[j]++;
                }
            }
        }
        return arr;
    }
}