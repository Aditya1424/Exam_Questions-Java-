
import java.util.*;
public class max_xor {
	
	public static  class Node{
		Node zero;
		Node one;
		
	}
	public static  void insert(Node root,int val)
	{
		Node curr=root;
		for(int i=31;i>=0;i--)
		{
			int bit=(val &(1<<i));
			if(bit==0)
			{
				if(curr.zero!=null)
				{
					curr=curr.zero;
				}
				else
				{
					Node nn=new Node();
					curr.zero=nn;
					curr=nn;
				}
			}
			else
			{
				if(curr.one!=null)
				{
					curr=curr.one;
				}
				else
				{
					Node nn=new Node();
					curr.one=nn;
					curr=nn;
				}
			}
		}
	}
	public static int getxor(Node root,int val)
	{
		Node curr=root;
	int xor=0;
		for(int i=31;i>=0;i--)
		{
			int bit=(val &(1<<i));
			if(bit==0)
			{
				if(curr.one!=null)
					{
					xor+=(1<<i);
					curr=curr.one;
					}
				else {
					curr=curr.zero;
				}
			}
				else
				{
					if(curr.zero!=null)
					{
						xor+=(1<<i);
					curr=curr.zero;
					}
					else
						curr=curr.one;
				}
			}
		
		return xor;
	}

	public static void main(String[] args) {
		int []nums = {3,10,5,25,2,8};
		Node root=new Node();
		for(int val:nums)
		{
			insert(root,val);// TODO Auto-generated method stub
		}
		int ans=Integer.MIN_VALUE;
		for(int val:nums)
		{
			ans=Math.max(ans, getxor(root,val));
		}
		System.out.println(ans);

	}

}
