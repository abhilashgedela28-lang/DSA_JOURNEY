class Solution {
    public boolean hasTripletSum(int arr[], int target) {
        // code Here
        Arrays.sort(arr);
        for(int i = 0;i<arr.length-2;i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k] == target){
                    return true;
                }
                else if(arr[i]+arr[j]+arr[k] > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return false;
    }
}
