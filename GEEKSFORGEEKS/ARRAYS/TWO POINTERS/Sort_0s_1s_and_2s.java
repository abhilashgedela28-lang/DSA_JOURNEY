class Solution {
    public void sort012(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int index = 0;
        for(int j = 0;j<3;j++){
            if(!map.containsKey(j)){
                continue;
            }
            for(int i = 0;i<map.get(j);i++){
                arr[index++] = j;
            }
        }
    }
}