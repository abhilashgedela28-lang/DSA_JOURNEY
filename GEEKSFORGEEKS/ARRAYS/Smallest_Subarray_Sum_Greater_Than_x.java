class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 0;j<arr.length;j++){
            sum += arr[j];
            while(sum > x){
                ans = Math.min(ans,j-i+1);
                sum -= arr[i++];
            }
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}
