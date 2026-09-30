class Solution {
    public int minBitFlips(int start, int goal) {
        int max = Math.max(start,goal);
        int min = Math.min(start,goal);
        int count = 0;

        while(max >0){
            int abit = max &1;
            int bbit = min&1;
            count += ((abit ^ bbit) == 1)?1:0;
            max = max >>1;
            min = min >> 1;
        }
        
        return count;
    }
}