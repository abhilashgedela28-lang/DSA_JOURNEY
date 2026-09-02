
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
		    if(n == 1){
		        System.out.println(20);
		    }
		    else if(n == 2){
		        System.out.println(30);
		    }
		    else{
		        if(n % 2 == 0){
		            System.out.println((n/2)*30);
		        }
		        else{
		            System.out.println((n/2)*30+20);
		        }
		    }
		}

	}
}
