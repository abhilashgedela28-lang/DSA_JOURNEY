//3016
// 1st approach 

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

// 2nd approach using priority queue

class Solution {
    public int minimumPushes(String word) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        int[] arr = new int[26];
        int ans = 0;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i) -'a';
            arr[ind]++;
        }
        for(int i = 0;i<26;i++){
            if(arr[i] != 0){
                pq.add(arr[i]);
            }
        }
        int count = 1;
        int val = 1;
        while(!pq.isEmpty()){
            int x = pq.poll();
            if(count <=8){
                val = 1;
            }
            else if(count>8 && count <= 16){
                val = 2;
            }
            else if(count >16 && count <= 24){
                val = 3;
            }
            else{
                val = 4;
            }
            ans += x*val;
            count++;
        }
        return ans;
       
    }
}
