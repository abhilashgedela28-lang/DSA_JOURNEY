class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.a > b.a){
                return -1;
            }
            else if(a.a < b.a){
                return 1;
            }
            else{
                return 0;
            }
        });

        int[] ans = new int[nums.length-k+1];
        for(int i  = 0;i< k;i++){
            Pair p = new Pair(nums[i],i);
            pq.add(p);
        }
        ans[0] = pq.peek().a;
        int index = 1;
        int j = 0;
        for(int i = k;i<nums.length;i++){
            Pair p = new Pair(nums[i],i);
            pq.add(p);
            while(pq.peek().b <= j){
                Pair p1 = pq.poll();
            }
            ans[index++] = pq.peek().a;
            j++;
        }
        return ans;
    }
}
