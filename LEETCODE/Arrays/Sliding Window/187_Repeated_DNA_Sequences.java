class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        
        if(s.length() <=10){
            // ans.add(s);
            return ans;
        }
        else{
            String sub1 = s.substring(0,10);
            StringBuilder sub = new StringBuilder(sub1);
            map.put(sub.toString(),1);
            int start = 0;
            for(int i = 10;i<s.length();i++){
                char ch = s.charAt(i);
                sub.deleteCharAt(start);
                sub.append(ch);
                map.put(sub.toString(),map.getOrDefault(sub.toString(),0)+1);
            }
            for(String x: map.keySet()){
                if(map.get(x) > 1){
                    ans.add(x);
                }
            }
        }
        return ans;
    }
}
