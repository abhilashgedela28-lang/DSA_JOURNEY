// Given a number n. Return the total count of set bits for all numbers from 1 to n (both inclusive).

//Input: n = 4
// Output: 5
// Explanation: For numbers from 1 to 4. for 1: 0 0 1 => 1 set bit, for 2: 0 1 0 => 1 set bit, for 3: 0 1 1 => 2 set bits, for 4: 1 0 0 => 1 set bit. Therefore, the total set bits are 5.


class Solution {
    public static int countSetBits(int n) {
        // code here
        int count = 0;
        for(int i = 0;(1<<i)<=n;i++){
            int half = 1 << i;
            int cycle = 1<< (i+1);
            
            count += (n+1)/cycle * half;
            count += Math.max(0,(n+1)%cycle - half);
        }
        return count;
    }
}

/* EXPLANATION 

         The code counts set bits bit-by-bit instead of checking every number from 1 to n.
         For each bit position i:
            half = 1 << i;
            cycle = 1 << (i + 1);
            half = 2^i → number of consecutive 0s or 1s.
            cycle = 2^(i+1) → length of the repeating pattern.
         For example:
            bit 0 → 0 1 0 1
            bit 1 → 0 0 1 1
            bit 2 → 0 0 0 0 1 1 1 1
         Then:
            count += (n + 1) / cycle * half;
            counts 1s from the complete cycles.
            count += Math.max(0, (n + 1) % cycle - half);
            counts 1s from the remaining incomplete cycle.
         Finally, all bit counts are added to get the total set bits.
         Complexity
            Time  : O(log n)
            Space : O(1)

*/