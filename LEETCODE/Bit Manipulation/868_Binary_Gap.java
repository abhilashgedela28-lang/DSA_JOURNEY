class Solution {
    public int binaryGap(int n) {
        int last = -1;
        int ans = 0;
        for(int i = 0;i<31;i++){
            if((n&(1<<i))!= 0){
                if(last == -1){
                    last = i;
                }
                else{
                    ans = Math.max(ans,i-last);
                    last = i;
                }
            }
        }
        return ans;
    }
}