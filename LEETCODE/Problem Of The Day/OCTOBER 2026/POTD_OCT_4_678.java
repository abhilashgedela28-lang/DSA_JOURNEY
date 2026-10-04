class Solution {
    int[][] dp;
    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        dp = new int[s.length()][s.length()+1];
        
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return fun(0, s, st);
    }

    public boolean fun(int ind, String s, Stack<Character> st) {

        if (ind == s.length()) {
            return st.isEmpty();
        }
        int open = st.size();

        if(dp[ind][open] != -1){
            return dp[ind][open] == 1;
        }

        boolean ans = false;
        char ch = s.charAt(ind);

        if (ch == '(') {
            st.push('(');
            ans = fun(ind + 1, s, st);
            st.pop();
        }

        else if (ch == ')') {
            if (st.isEmpty()) {
                return false;
            }

            st.pop();
            ans = fun(ind + 1, s, st);
            st.push('(');

        }

        else { 
            st.push('(');
            boolean val1 = fun(ind + 1, s, st);
            st.pop();

            
            boolean val2 = fun(ind + 1, s, st);

            boolean val3 = false;

            if (!st.isEmpty()) {
                st.pop();
                val3 = fun(ind + 1, s, st);
                st.push('(');
            }

            ans= val1 || val2 || val3;
        }
        dp[ind][open] = ans?1:0;
        return ans;
    }
}