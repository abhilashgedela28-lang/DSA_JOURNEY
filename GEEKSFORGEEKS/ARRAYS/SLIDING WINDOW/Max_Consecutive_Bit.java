class Solution {
    public int maxConsecBits(int[] arr) {
        // code here
        int j = 0;
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            while(arr[i] != arr[j]){
                j++;
            }
            ans = Math.max(ans,i-j+1);
        }
        return ans;
    }
}
