/* 

    Given a non negative integer n, check whether its binary representation consists of alternating bits. 

        Examples 
            Input: n = 12
            Output: false
            Explanation: n = 12 = "1100". Hence there is no alternate pattern.

            Input: n = 10
            Output: true
            Explanation: n = 10 = "1010". Hence n has an alternate pattern.

*/

class Solution {
    public boolean alternateBits(int n) {
        // code here
        while(n > 0){
            int v1 = n&1;
            n = n>>1;
            int v2 = n&1;
            if(v1 == v2){
                return false;
            }
        }
        return true;
    }
}