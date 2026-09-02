import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int[] arr = new int[n];
		    int total = 0;
		    for(int i = 0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    int ans = 0;
		    for(int i = 0;i<n-k;i++){
		        total += arr[i];
		    }
		    ans = total;
		    int j = 0;
		    for(int i = n-k;i<n;i++){
		        total += arr[i];
		        total -= arr[j];
		        ans = Math.max(total,ans);
		        j++;
		    }
		    System.out.println(ans);
		}

	}