class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        String ans = "";
        int len = Integer.MAX_VALUE;
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }
        int matched = 0;
        int i = 0;
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch)){
                if(tmap.get(ch).intValue() == smap.get(ch).intValue()){
                    matched++;
                }
            }
            while(matched == tmap.size()){
                String sam = s.substring(i,j+1);
                if(len > j+1 - i){
                    ans = sam;
                    len = j+1-i;
                }
                char ch2 = s.charAt(i);
                int val = smap.get(ch2);
                smap.put(ch2,val-1);
                if(tmap.containsKey(ch2) && (smap.get(ch2).intValue() < tmap.get(ch2).intValue())){
                    matched--;
                }
                if(smap.get(ch2).intValue() == 0){
                    smap.remove(ch2);
                }
                i++;
            }
        }
        return ans;
    }
}
