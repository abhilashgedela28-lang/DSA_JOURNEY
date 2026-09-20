class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans =0;
        for(int i = 0;i<n;i++){
            char ch =  s.charAt(i);
            int val = 'z' - ch;
            ans += (i+1)*(val+1);
        }
        return ans;
    }
}