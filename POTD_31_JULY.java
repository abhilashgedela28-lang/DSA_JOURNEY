//3016

class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        int ans = 0;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i) -'a';
            arr[ind]++;
        }
        Arrays.sort(arr);
        int count = 1;
        int val = 1;
        for(int i = 25;i>-1;i--){
            if(arr[i] != 0){
                ans += arr[i]*val;
                count++;
            }
            if(count>8 && count <= 16){
                val = 2;
            }
            else if(count > 16 && count <= 24){
                val = 3;
            }
            else if(count > 24){
                val = 4;
            }
        }
        return ans;
    }
}
