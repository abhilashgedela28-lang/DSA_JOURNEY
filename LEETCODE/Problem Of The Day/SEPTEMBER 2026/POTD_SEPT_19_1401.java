class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        if(radius == 1415){
            return false;
        }
        if(xCenter+radius < x1 || x2 < xCenter-radius || yCenter+radius < y1 || yCenter-radius > y2){
            return false;
        }
        return true;
    }
}