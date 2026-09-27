class Solution {
    public int getSum(int a, int b) {
        int ans = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {
            int abit = (a >>> i) & 1;
            int bbit = (b >>> i) & 1;

            int sum = abit^bbit^carry;

            if(sum == 1){
                ans |= (1<<i);
            }
            carry = (abit & bbit)|(abit & carry)|(bbit & carry);
            
        }
        return ans;
    }
}