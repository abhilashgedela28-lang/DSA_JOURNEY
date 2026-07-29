//Product Exceed

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
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();
            int count = 0;
            while(x * y < p){
                if((x+1) * y > (y+1)*x){
                    x++;
                }
                else{
                    y++;
                }
                count++;
            }
            System.out.println(count);
        }
	}
}
