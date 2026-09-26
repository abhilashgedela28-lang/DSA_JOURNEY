class Solution {
    public boolean canTransform(int[] source, int[] target) {
        if(source.equals(target)){
            return true;
        }
        long stotal = 0;
        long ttotal = 0;
        for(int i :source){
            stotal += i;
        }
        for(int x:target){
            ttotal += x;
        }
        if(stotal == ttotal){
            return true;
        }
        return false;
    }
}©leetcode