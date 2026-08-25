class Solution {
    public int maxWater(int arr[]) {
        // code here
        int left = 0;
        int right = arr.length-1;
        int lmax = 0;
        int rmax = 0;
        int water = 0;
        
        while(left < right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= lmax){
                    lmax = arr[left];
                }
                else{
                    water += lmax - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= rmax){
                    rmax = arr[right];
                }
                else{
                    water += rmax - arr[right];
                }
                right--;
            }
        }
        
        return water;
    }
}
