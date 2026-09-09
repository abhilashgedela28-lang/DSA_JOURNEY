import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            String str2 = sc.next();
            int a = 0;
            int b = 0;
            for(int i = 0;i<n;i++){
                if(str.charAt(i) == 'a'){
                    a++;
                }
                else{
                    b++;
                }
            }
            for(int i = 0;i<n;i++){
                if(str2.charAt(i) == 'a'){
                    a++;
                }
                else{
                    b++;
                }
            }
            if(a == b){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
	}
}
