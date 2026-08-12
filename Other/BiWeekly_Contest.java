class Solution {
    public int countValidPrefixes(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1'){
                if(i == 0){
                    arr[i] = 1;
                }
                else{
                    arr[i] = arr[i-1] + 1;
                }
            }
            else{
                if(i!= 0){
                    arr[i] = arr[i-1];
                }
            }
        }
        int ans = 1;
        boolean flag = false;
        if(arr[0] == 1){
            flag = true;
        }
        for(int i = 2;i<=s.length();i++){
            float val = (float)arr[i-1];
            if(i%2 == 0){
                if(i/2 == (int)val){
                    ans++;
                }
            }
            else{
                if(i - val == (i+1)/2-1 || i-val == (i+1)/2){
                         ans++;
                    }
                
            }
        }
        return ans;
    }
}
