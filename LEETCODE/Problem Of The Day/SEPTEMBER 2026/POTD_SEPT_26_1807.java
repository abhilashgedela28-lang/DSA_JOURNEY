class Solution {
    public String evaluate(String s, List<List<String>> list) {
        HashMap<String,String> map = new HashMap<>();
        for(int i =0;i<list.size();i++){
            map.put(list.get(i).get(0),list.get(i).get(1));
        }
        String ans = "";
        boolean open = false;
        String word = "";
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open = true;
            }
            else if(ch == ')'){
                if(map.containsKey(word)){
                    ans+= map.get(word);
                }
                else{
                    ans += '?';
                }
                open = false;
                word = "";
            }
            else if(open == true){
                word += ch;
                continue;
            }
            else{
                ans += ch;
            }
        }
        return ans;
    }
}