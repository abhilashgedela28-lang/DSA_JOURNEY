import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int  x = sc.nextInt();
        int y = sc.nextInt();
        int f = sc.nextInt();
        System.out.println(Math.min(12*x,12*y+f));
	}
}
