class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(n,n,"",ans);
        return ans;
    }

    public void f(int lcount,int rcount,String str,List<String> ans){
        if(lcount == 0 && rcount == 0){
            ans.add(str);
        }
        if(lcount >0){
            f(lcount-1,rcount,str + '(',ans);
        }
        if(lcount < rcount){
            f(lcount,rcount-1,str+')',ans);
        }
    }
}