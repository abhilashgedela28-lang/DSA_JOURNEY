import java.math.BigInteger;

class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {

        int n = nums.length;
        int subsets = 1 << n;

        BigInteger total = BigInteger.ONE;

        for (int x : nums) {
            total = total.multiply(BigInteger.valueOf(x));
        }

        BigInteger t = BigInteger.valueOf(target);
        BigInteger targetSquare = t.multiply(t);

        if (!total.equals(targetSquare)) {
            return false;
        }

        for (int i = 1; i < subsets - 1; i++) {

            BigInteger p = BigInteger.ONE;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    p = p.multiply(BigInteger.valueOf(nums[j]));

                    if (p.compareTo(t) > 0) {
                        break;
                    }
                }
            }

            if (p.equals(t)) {
                return true;
            }
        }

        return false;
    }
}