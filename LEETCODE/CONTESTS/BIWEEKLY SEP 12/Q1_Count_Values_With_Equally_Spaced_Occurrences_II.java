class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> a = map.get(nums[i]);
                a.add(i);
                map.put(nums[i],a);
            }
            else{
                ArrayList<Integer> b = new ArrayList<>();
                b.add(i);
                map.put(nums[i],b);
            }
        }
        int ans = 0;
        for(int x :map.keySet()){
            ArrayList<Integer> list = map.get(x);
            if(list.size() >=3){
                int diff =list.get(1) - list.get(0);
                boolean flag = true;
                for(int i = 2;i<list.size();i++){
                    if(list.get(i) - list.get(i-1) != diff){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans++;
                }
                
            }
        }
        return ans;
    }
}©leetcode