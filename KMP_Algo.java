
import java.util.*;
public class kmp_nhay {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt())
		{
			int n=sc.nextInt();
			String pat=sc.next();
			String str=sc.next();
			kmp(str,pat);// TODO Auto-generated method stub
		}

	}
	public static void kmp(String s,String pat)
	{
		String str=pat+"#"+s;
	
		int dp[]=new int[str.length()];
		dp[0]=0;
		int len=0;
		for(int i=1;i<dp.length; )
		{
			if(str.charAt(i)==str.charAt(len))
			{
				len++;
				dp[i]=len;
				i++;
			}
			else
			{
				if(len>0)
					len=dp[len-1];
				else
					i++;
			}
				
		}
		for(int i=pat.length();i<dp.length;i++)
		{
			if(dp[i]==pat.length())
			System.out.println(i-2*pat.length());
		}
		System.out.println();
	}

}
