class Solution {
    public boolean sumGame(String num) {
        int lcount = 0;
        int rcount = 0;
        int lsum = 0;
        int rsum = 0;

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            if (ch == '?') {
                if (i < num.length() / 2) {
                    lcount++;
                } else {
                    rcount++;
                }
            } else {
                int val = ch - '0';

                if (i < num.length() / 2) {
                    lsum += val;
                } else {
                    rsum += val;
                }
            }
        }

        int diff = lsum - rsum;
        int countDiff = rcount - lcount;
        if ((lcount + rcount) % 2 == 1) {
            return true;
        }

        return 2 *diff != 9 * countDiff;
    }
}