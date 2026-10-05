class Solution {
    public String addBinary(String a, String b) {
        String ans = "";
        int carry = 0;
        int aind = a.length() - 1;
        int bind = b.length() - 1;
        int sum = 0;

        while (aind >= 0 && bind >= 0) {
            int aval = a.charAt(aind) - '0';
            int bval = b.charAt(bind) - '0';

            if (aval == 1 && bval == 1) {
                if (carry == 1) {
                    ans = '1' + ans;
                } else {
                    ans = '0' + ans;
                }
                carry = 1;
            } 
            else if (aval == 1 || bval == 1) {
                if (carry == 1) {
                    ans = '0' + ans;
                    carry = 1;
                } 
                else {
                    ans = '1' + ans;
                }
            } 
            else {
                if (carry == 1) {
                    ans = '1' + ans;
                    carry = 0;
                } 
                else {
                    ans = '0' + ans;
                }
            }

            aind--;
            bind--;
        }

        for (int i = aind; i >= 0; i--) {
            char val = a.charAt(i);

            if (carry == 1) {
                if (val == '0') {
                    ans = '1' + ans;
                    carry = 0;
                } 
                else {
                    ans = '0' + ans;
                    carry = 1;
                }
            } 
            else {
                ans = val + ans;
            }
        }

        for (int i = bind; i >= 0; i--) {
            char val = b.charAt(i);

            if (carry == 1) {
                if (val == '0') {
                    ans = '1' + ans;
                    carry = 0;
                } 
                else {
                    ans = '0' + ans;
                    carry = 1;
                }
            } 
            else {
                ans = val + ans;
            }
        }

        if (carry == 1) {
            ans = '1' + ans;
        }

        return ans;
    }
}