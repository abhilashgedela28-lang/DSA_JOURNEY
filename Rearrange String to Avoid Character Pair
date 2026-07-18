// code in java

class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ans = new StringBuilder();
        int xo = -1;
        int fx= 0;
        int fy = 0;
        int yo = -1;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == x ){
                xo = i;
                fx++;
            }
            if(ch == y){
                yo = i;
                fy++;
            }
        }
        if(xo == -1 || yo == -1){
            return s;
        }
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch != x && ch != y){
                ans.append(ch);
            }
        }
        for(int i = 0;i<fy;i++){
            ans.append(y);
        }
        for(int i = 0;i<fx;i++){
            ans.append(x);
        }
        return ans.toString();
    }
}
