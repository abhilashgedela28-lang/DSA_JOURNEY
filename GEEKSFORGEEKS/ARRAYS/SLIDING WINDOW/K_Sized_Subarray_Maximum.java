class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            return b.x - a.x;
        });
        for(int i = 0;i<k;i++){
            Pair p = new Pair(arr[i],i);
            
            pq.add(p);
        }
        int j = 0;
        ans.add(pq.peek().x);
        for(int i = k;i<arr.length;i++){
            Pair p = new Pair(arr[i],i);
            pq.add(p);
            while(pq.peek().y <= j ){
                pq.remove();
            }
            ans.add(pq.peek().x);
            j++;
        }
        return ans;
        
    }
}