import java.util.*;
public class Fernandes_Path  {
    static int mod=1000000007;
    static String ans="";
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean p[]=new boolean[1000000];

        prime(p);
        int mat[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        long ways[][]=new long[n][m];
        ways[0][0]=1;
        for(int i=1;i<m;i++){
            if(!p[mat[0][i]])ways[0][i]+=ways[0][i-1];
        }
        for(int i=1;i<n;i++){
            if(!p[mat[i][0]])ways[i][0]+=ways[i-1][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(!p[mat[i][j]]){
                    ways[i][j]=((ways[i-1][j]+ways[i][j-1])%mod+ways[i-1][j-1])%mod;
                }
            }
        }
        System.out.println(ways[n-1][m-1]);
        Integer dp[][]=new Integer[n][m];
        ways(mat,0,0,n,m,"1 1\n",p,dp);
        if(!ans.equals(""))System.out.println(ans);
    }
    static int ways(int mat[][],int i,int j,int n,int m,String s,boolean p[],Integer dp[][]){
        if(i>=n||j>=m||p[mat[i][j]]||!ans.equals(""))return 0;
        if(i==n-1&&j==m-1){
            if(ans.equals(""))ans=s;
            return 1;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int way=ways(mat,i+1,j+1,n,m,s+(i+2)+" "+(j+2)+"\n",p,dp);
        way=(way+ways(mat,i+1,j,n,m,s+(i+2)+" "+(j+1)+"\n",p,dp))%mod;
        way=(way+ways(mat,i,j+1,n,m,s+(i+1)+" "+(j+2)+"\n",p,dp))%mod;
        return dp[i][j]=way;
    }
    static void prime(boolean a[]){
        int n=a.length;
        a[0]=true;
        if(n>1)a[1]=true;
        for(int i=2;i<n;i++){
            if(!a[i]){
                for(int j=2;j*i<n;j++){
                    a[j*i]=true;
                }
            }
        }
    }
}
