
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n + 1][m + 1];

        return f(n, m, s, p, dp);
    }

    public boolean f(int i, int j, String s, String p,
                     Boolean[][] dp) {

        if (i == 0 && j == 0) {
            return true;
        }

        if (j == 0) {
            return false;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == 0) {
            if (p.charAt(j - 1) == '*') {
                return dp[i][j] =
                    f(i, j - 2, s, p, dp);
            }

            return dp[i][j] = false;
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) ||
            p.charAt(j - 1) == '.') {

            return dp[i][j] =
                f(i - 1, j - 1, s, p, dp);
        }

        if (p.charAt(j - 1) == '*') {

            if (s.charAt(i - 1) == p.charAt(j - 2) ||
                p.charAt(j - 2) == '.') {

                return dp[i][j] =
                    f(i, j - 2, s, p, dp) ||
                    f(i - 1, j, s, p, dp);
            }

            return dp[i][j] =
                f(i, j - 2, s, p, dp);
        }

        return dp[i][j] = false;
    }
}