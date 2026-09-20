class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long[] arr= new long[26];

        for(char ch: s.toCharArray()){
            int index = ch - 'a';

            long total = 1;
            for(int i = 0;i<26;i++){
                total  = (total%mod + arr[i]%mod)%mod;
            }

            arr[index] = total;
        }

        long ans = 0;
        for(long x: arr){
            ans = (ans%mod + x % mod)%mod;
        }
        return (int)ans;
    }
}