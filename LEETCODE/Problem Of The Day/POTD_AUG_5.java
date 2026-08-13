class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList());
        }

        for(int i =0;i<invocations.length;i++){
            int from = invocations[i][0];
            int end = invocations[i][1];
            list.get(from).add(end);
        }
        boolean[] def = new boolean[n];
        dfs(k,list,def);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] edge: invocations){
            int from = edge[0];
            int to = edge[1];

            if(!def[from] && def[to]){
                for(int i = 0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        for(int i = 0;i<n;i++){
            if(!def[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public void dfs(int k,ArrayList<ArrayList<Integer>> list, boolean[] def){
        def[k] = true;
        for(int x: list.get(k)){
            if(!def[x]){
                dfs(x,list,def);
            }
        }
    }
}
