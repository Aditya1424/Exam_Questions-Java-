
import java.util.*;
public class avenger_and_end_game {

	public static void main(String[] args) {
		int []prime={2,3,5};
		int n=1000;
		System.out.println(countavenger(prime,n));// TODO Auto-generated method stub

	}
	public static int countavenger(int[]prime,int n)
	{
		int len=prime.length;
		int ans=0;
		for(int i=1;i<(1<<len);i++)
		{
			if((count(i)&1)!=0)
			{
				ans=ans+intersection(prime,n,i);
			}
			else
				ans=ans-intersection(prime,n,i);
		}
		return ans;
	}
	public static int intersection(int[]prime,int n,int i)
	{
		int p=1;
		int pos=0;
		while(i>0)
		{
			if((i&1)!=0)
				p*=prime[pos];
			pos++;
			i>>=1;
		}
		return n/p;
	}
	public static int count(int n)
	{
		int c=0;
		while(n>0)
		{
			c++;
			n=n&(n-1);
		}
		return c;
	}


}
