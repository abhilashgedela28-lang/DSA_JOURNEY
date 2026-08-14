class Solution {
    public int maximumLengthSubstring(String s) {
        int len = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch) > 2){
                char ch2 = s.charAt(i);
                int val = map.get(ch2);
                map.put(ch2,val- 1);
                i++;
            }
            len = Math.max(len,j-i+1);
        }
        return len;
    }
}