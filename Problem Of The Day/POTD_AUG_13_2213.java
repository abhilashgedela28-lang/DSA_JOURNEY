// Brute force solution which will gives you TLE

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        StringBuilder str = new StringBuilder(s);
        int[] ans = new int[queryIndices.length];
        int index = 0;
        for(int i = 0;i<queryIndices.length;i++){
            int ind = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            str.setCharAt(ind,ch);
            int num = longSeq(str.toString());
            ans[index++] = num;
        }
        return ans;
    }

    public int longSeq(String str){
        int start = 0;
        int maxlen = 0;
        for(int i = 0;i<str.length();i++){
            char ch1 = str.charAt(start);
            char ch2 = str.charAt(i);
            if(ch1 != ch2){
                start = i;
            }
            maxlen = Math.max(i-start+1,maxlen);
        }
        return maxlen;
    }
}


