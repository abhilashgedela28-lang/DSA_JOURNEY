class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        StringBuilder str = new StringBuilder();
        String ans = "";
        int len = s.length();
        int start = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                count++;
            }
            str.append(ch);
            while(count > k){
                if(s.charAt(start) == '1'){
                    count--;
                }
                str.deleteCharAt(0);
                start++;
            }
            while(str.length() >0 && str.charAt(0) == '0' ){
                // System.out.println(str);
                str.deleteCharAt(0);
                start++;
            }
            
            if(count == k){
                
                if(len > (i-start+1) ){
                    len = i-start+1;
                    ans = find(str.toString(),ans);
                }
                else if(len == i-start+1){
                    ans = find(str.toString(),ans);
                    System.out.println("equal");
                }
                System.out.println(str);
                System.out.println(ans);
            }
        }
        return ans;
    }

    public String find(String str1,String ans){
        if(ans.length() == 0 || str1.length() < ans.length()){
            return str1;
        }
        else{
            for(int i = 0;i<str1.length();i++){
                if(str1.charAt(i) == ans.charAt(i)){
                    if(i == str1.length()-1){
                        return ans;
                    }
                    else{
                        continue;
                    }
                }
                if(str1.charAt(i) > ans.charAt(i)){
                    return ans;
                }
                else{
                    return str1;
                }
            }
        }
        return "";
    }
}