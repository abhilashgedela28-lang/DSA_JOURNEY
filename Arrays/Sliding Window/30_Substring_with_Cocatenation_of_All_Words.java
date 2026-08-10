class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> tmap = new HashMap<>();
        HashMap<String,Integer> smap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int limit = words[0].length();
        int size = words.length*limit;
        for(int i = 0;i<words.length;i++){
            tmap.put(words[i],tmap.getOrDefault(words[i],0)+1);
        }
        int i = 0;
        int j = size-1;
        String sub = "";
        while(j < s.length()){
            boolean flag = true;
            sub = s.substring(i,j+1);
            HashMap<String,Integer> mapa = new HashMap<>();
            freq(mapa,limit,sub);
            if(tmap.equals(mapa)){
                ans.add(i);
            }
            i++;
            j++;
        }
        return ans;

    }
    public void freq(HashMap<String,Integer> map,int limit,String s){
        for(int i = 0;i<s.length();i += limit){
            String sub = s.substring(i,i+limit);
            map.put(sub,map.getOrDefault(sub,0)+1);
        }
    }
}
