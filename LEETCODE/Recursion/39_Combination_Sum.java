class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sam = new ArrayList<>();
        f(candidates.length-1,sam,candidates,target);
        return ans;
    }

    public void f(int n,List<Integer> list,int[] arr,int sum){
        if(sum == 0){
            ans.add(new ArrayList<>(list));
            return ;
        }
        if(n < 0){
            return ;
        }
        
        f(n-1,list,arr,sum);
        if(sum >= arr[n]){
            list.add(arr[n]);
            f(n,list,arr,sum-arr[n]);
            list.remove(list.size()-1);
        }
        return ;
    }
}