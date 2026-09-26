class Solution {
    public String removeTrailingZeros(String num) {
        StringBuilder ans = new StringBuilder(num);
        for(int i = 0;i<num.length();i++){
            char ch = ans.charAt(i);
            if(ch != '0'){
                break;
            }
            else{
                ans.deleteCharAt(i);
            }
        }
        for(int i = num.length()-1;i>=0;i--){
            char ch = ans.charAt(i);
            if(ch != '0'){
                break;
            }
            else{
                ans.deleteCharAt(i);
            }
        }
        return ans.toString();
    }
}