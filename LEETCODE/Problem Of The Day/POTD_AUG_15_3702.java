class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        long sum = 0;

        for (int num : nums) {
            xor ^= num;
            sum += num;
        }

        if (sum == 0)
            return 0;

        if (xor != 0)
            return nums.length;

        return nums.length - 1;
    }
}