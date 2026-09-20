/* Tabulation + Space Optimization 
    time Complexity: O(n)
    Space Complexity: O(1)
*/

class Solution {
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;
        int curr = 1;
        for(int i = 2;i<=n;i++){
            curr = prev2+prev;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}