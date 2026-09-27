class Solution {
    public int integerReplacement(int n) {
        return f((long)n);
    }

    public int f(long n){
        if(n == 1){
            return 0;
        }

        int add = (int)1e9;
        int sub = (int)1e9;
        int even = (int)1e9;
        if((n&1) == 0){
            even = 1+f(n/2);
        }
        else{
            add = 1+f(n+1);
            sub = 1+f(n-1);
        }
        
        return (int) Math.min(even,Math.min(add,sub));
    }
}