class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();
        int subsets = 1<<n;

        for(int i = 0;i<subsets;i++){

            int num = 0;
            boolean fp = false;
            int prev = 0;
            
            for(int bp = 31;bp>=0;bp--){

                if(fp == false && (i&(1<<bp))!= 0){
                    fp = true;
                    num += 1;
                    prev = 1;
                }
                else{
                    num <<= 1;
                    int bit = (i>>>bp& 1);
                    num += (bit^prev);
                    prev = bit;
                }
            }
            
            ans.add(num);
        }
        return ans;
    }
}