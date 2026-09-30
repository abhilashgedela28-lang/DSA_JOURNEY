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
		    int m = sc.nextInt();
		    int k = sc.nextInt();
		    ArrayList<Integer> list = new ArrayList<>();
		    for(int i = 0;i<m;i++){
		        list.add(sc.nextInt());
		    }
		    for(int i = 1;i<=n;i++){
		        if(k == 0){
		            break;
		        }
		        if(list.indexOf(i) == -1){
		            System.out.print(i+" ");
		            k--;
		        }
		    }
		    System.out.println();
		}

	}
}
