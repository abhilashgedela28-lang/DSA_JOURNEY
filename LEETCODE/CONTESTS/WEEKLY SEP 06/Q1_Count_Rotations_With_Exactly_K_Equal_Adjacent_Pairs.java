class Solution {
    public int countRotations(String s, int k) {
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            int score = 0;
            String sub = s.substring(i+1,s.length())+ s.substring(0,i+1);
            System.out.println(sub);
            for(int j = 0;j<s.length()-1;j++){
                if(sub.charAt(j) == sub.charAt(j+1)){
                    score++;
                }
            }
            if(score == k){
                ans++;
            }
        }
        return ans;
    }
}