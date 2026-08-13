
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length-1]);
    }

    public int gcd(int x,int y){
        int b = Math.min(x,y);
        int a = Math.max(x,y);
        while(b!= 0){
            int temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }
}
