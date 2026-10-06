class Solution {
    public char findTheDifference(String s, String t) {
        int total = 0;

        for(char ch: s.toCharArray()){
            total ^= (int)ch;
        }

        for(char ch: t.toCharArray()){
            total ^= (int)ch;
        }

        return (char)total;
    }
}