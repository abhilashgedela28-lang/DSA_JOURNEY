// Calculating the powers of numbers in logn complexity
/* 
  13 = 1101₂
  
  ans = 1
  base = 5
  
  13 (odd) -> ans = 1 * 5 = 5
              base = 25
              exp = 6

  6 (even) -> ans = 5
              base = 625
              exp = 3

  3 (odd) -> ans = 5 * 625 = 3125
              base = 625²
              exp = 1

  1 (odd) -> multiply once more
              exp = 0
*/

class Solution {
    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n)/2;

        long evalue = recur(5,even);
        long ovalue = recur(4,odd);

        return (int) ((evalue*ovalue)%mod);
    }

    public long recur(long base,long exp){
        long ans = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                ans = ((ans)*(base))%mod;
            }

            base = ((base)*(base))%mod;
            exp >>= 1;
        }
        return ans;
    }
}

