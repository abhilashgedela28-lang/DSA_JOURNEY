class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int x1 = source[0];
        int y1 = source[1];
        int x2 = target[0];
        int y2 = target[1];
        int xdiff = Math.abs(x2-x1);
        int ydiff = Math.abs(y2-y1);
        int ans = 10;
        if(x1 == x2 && y1 == y2){
            return 0;
        }
        if(xdiff== ydiff){
            return 1;
        }
        if(xdiff!= ydiff){
            return 2;
        }
        if(xdiff == 0||(ydiff == 0)){
            return 1;
        }
        return 0;
    }
}©leetcode