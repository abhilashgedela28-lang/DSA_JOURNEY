class Solution {
    public long pairAndSum(int[] arr) {
        // code here
        long ans = 0;
        for(int i = 0;i<31;i++){
            long count = 0;
            for(int x:arr){
                if((x&(1<<i)) != 0){
                    count++;
                }
            }
            long pairs = (count * (count-1))/2;
            ans += pairs * (1L << i);
        }
        return ans;
    }
}