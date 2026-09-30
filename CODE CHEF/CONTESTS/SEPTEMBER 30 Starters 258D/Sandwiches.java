import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int h = sc.nextInt();
        int c = sc.nextInt();
        if(b/2 <= (h+c)){
            System.out.println(b/2);
        }
        else{
            System.out.println(h+c);
        }
	}
}
