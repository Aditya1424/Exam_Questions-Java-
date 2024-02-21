
import java.util.*;
public class hash_code {

	public static void main(String[] args) {
		String str="APPLE";// TODO Auto-generated method stub

	}
	public static long hashcode(String str)
	{
	long mod=1000000007;
	long pow=1;
	long prime=31;
	long hv=0;
	for(int i=0;i<str.length();i++)
	{
		int pos=str.charAt(i)-'A'+1;
		hv=(hv+(pos*pow)%mod)%mod;
		pow=(pow*prime)%mod;
	}
	return hv;
	}
}
