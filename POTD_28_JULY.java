//question
// You are given a palindromic string s.
//Return the lexicographically smallest palindromic permutation of s.

class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch-'a']++;
        }
        if(s.length() == 1){
            return s;
        }
        StringBuilder left = new StringBuilder();
        int flag = -1;
        for(int i = 0;i<26;i++){
            int j = 0;
            if(arr[i]%2 == 1){
                flag = i;
            }
            int h = arr[i]/2;
            while( h -- >0){
                left.append((char) (i+97));
            }
        }
        StringBuilder right = new StringBuilder(left);
        right.reverse();
        if(flag != -1){
            left.append((char)(flag + 97));
        }
        left.append(right);
        
        return left.toString();
    }
}
