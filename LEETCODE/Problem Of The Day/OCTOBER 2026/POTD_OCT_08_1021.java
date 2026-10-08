class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push('(');
                if(st.size()>1){
                    ans += "(";
                }
            }
            else{
                if(st.size() > 1){
                    ans += ")";
                }
                st.pop();
            }
        }
        return ans;
    }
}