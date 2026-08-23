class Solution {
    public int totalElements(int[] arr) {
        // code here
        int i = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int j = 0;j<arr.length;j++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size() > 2){
                if(map.get(arr[i]) == 1){
                    map.remove(arr[i]);
                }
                else{
                    map.put(arr[i],map.get(arr[i]).intValue()-1);
                }
                i++;
            }
            ans = Math.max(j-i+1,ans);
        }
        return ans;
    }
}