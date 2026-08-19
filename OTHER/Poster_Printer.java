import java.util.*;

public class Solution {
    public boolean canPrintPoster(String s) {
        // Write your solution here
        for(int i = 1;i<s.length();i++){
            char ch1 = s.charAt(i-1);
            char ch2 = s.charAt(i);
            if(ch1 - 'A' > ch2 - 'A'){
                return false;
            }
        }
        return true;
    }
}
