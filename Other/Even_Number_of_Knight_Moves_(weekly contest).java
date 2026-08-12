class Solution {
    public boolean canReach(int[] start, int[] target) {
        int x = Math.abs(start[0] - target[0]);
        int y = Math.abs(start[1] - target[1]);
        if((x+y)%2 == 0){
            return true;
        }
        return false;
        
    }
}
