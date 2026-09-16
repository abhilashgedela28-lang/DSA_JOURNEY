class Solution {
    public int dominantPairs(int[] arr) {
        // Code here
        int n = arr.length;
        int ans= 0;
        int[] left = new int[n/2];
        int[] right = new int[n/2];
        for(int i = 0;i<n;i++){
            if(i < n/2){
                left[i] = arr[i];
            }
            else{
                right[i-n/2] = arr[i]*5;
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int edge = n/2 -1;
        for(int i = n/2-1;i>-1;i--){
            while(edge > -1 && left[i] < right[edge]){
                edge--;
            }
            if(edge >=0){
                ans += edge+1;
            }
            else{
                break;
            }
        }
        return ans;
    }
}