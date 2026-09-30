class Solution {
    public int hammingDistance(int x, int y) {
        int max = Math.max(x,y);
        int min = Math.min(x,y);
        int count = 0;
        while(max > 0){
            count += (max & 1)^(min & 1);
            max >>= 1;
            min >>= 1;
        }
        return count;
    }
}