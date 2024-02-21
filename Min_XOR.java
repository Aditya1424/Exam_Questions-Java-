

import java.util.*; //find a number X such that X XOR A is minimum and no.of set bits in x is equal to that in b 
public class minimum_xor {

	public static void main(String[] args) {
		int a=11;
		int b=125;
		// TODO Auto-generated method stub

	}
	public static int minval(int a,int b)
	{
		int c=count(b);
		int x=0;
		for(int i=31;i>=0 && c>0;i--)
		{
			if((a&(1<<i))!=0)
			{
				x+=(1<<i);
				c--;
			}
		}
		for(int i=0;i<=31 &&c>0;i++)
		{
			if((a&(1<<i))==0)
			{
				x+=(1<<i);
				c--;
			}
		}
		return x;
	}
	public static int  count(int b)
	{
		int c=0;
		while(b>0)
		{
			c++;
			b=b&(b-1);
		}
		return c;
	}

}
