class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;

        boolean sign = false;

        if (dividend >= 0 && divisor < 0) sign = true;
        if (dividend < 0 && divisor > 0) sign = true;

        long d = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        long ans = 0;

        while (d >= n) {
            int cnt = 0;

            while (d >= (n << (cnt + 1))) {
                cnt++;
            }

            ans += 1L << cnt;  
            d = d - (n << cnt);
        }

        if (ans == (1L << 31)) {
            if (sign) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (sign) {
            return (int) -ans;
        }

        return (int) ans;
    }
}