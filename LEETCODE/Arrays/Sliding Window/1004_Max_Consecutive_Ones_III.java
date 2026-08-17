/* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

*/


class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int count = 0;
        int start = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0 ){
                if(count>= 0 && count <= k){
                    count++;
                }
                while(count > k){
                    if(nums[start] == 0){
                        count--;
                    }
                    start++;
                }
            }
            ans = Math.max(ans,i-start+1);
            System.out.println(count);
        }
        return ans;
    }
}