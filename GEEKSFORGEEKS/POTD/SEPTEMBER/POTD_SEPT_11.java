// Values with Equal Array Remainders

class Solution {
    public int sameMod(int[] arr) {
        // code here
        int max = 0;
        
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        
        int count = 0;
        
        for(int i = 1;i<= max;i++){
            
            boolean flag = false;
            
            for(int j = 1;j<arr.length;j++){
                
                if(arr[j] % i != arr[j-1]%i){
                    
                    flag = true;
                    break;
                }
                
            }
            
            if(!flag){
                count++;
            }
        }
        
        if(count == max){
            return -1;
        }
        
        return count;
        
    }
}